package com.avaliacao.last_lp2.service;

import com.avaliacao.last_lp2.dto.LeilaoDTO;
import com.avaliacao.last_lp2.entity.Leilao;
import com.avaliacao.last_lp2.repository.LeilaoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LeilaoService {

    private final LeilaoRepository leilaoRepository;

    public LeilaoService(LeilaoRepository leilaoRepository) {
        this.leilaoRepository = leilaoRepository;
    }

    // Atualiza o status de todos os leilões periodicamente (a meia noite)
    @Scheduled(cron = "0 0 0 * * *")
    public void atualizarStatusLeiloes() {
        List<Leilao> leiloes = leilaoRepository.findAll();
        LocalDate hoje = LocalDate.now();

        for (Leilao leilao : leiloes) {
            String novoStatus;
            if (leilao.getDataOcorrencia().isAfter(hoje)) {
                novoStatus = "Em aberto";
            } else if (leilao.getDataOcorrencia().isBefore(hoje)) {
                novoStatus = "Finalizado";
            } else {
                novoStatus = "Em andamento";
            }

            // Apenas atualiza se o status tiver mudado
            if (!leilao.getStatus().equals(novoStatus)) {
                leilao.setStatus(novoStatus);
                leilaoRepository.save(leilao);  // Atualiza o leilão no banco de dados
            }
        }
    }

    // Registro de um novo leilão
    public LeilaoDTO registrarLeilao(LeilaoDTO leilaoDTO) {
        String varStatus;
        if (leilaoDTO.getDataOcorrencia().isAfter(LocalDate.now())) {
            varStatus = "Finalizado";
        } else if (leilaoDTO.getDataOcorrencia().isBefore(LocalDate.now())) {
            varStatus = "Em aberto";

        } else {
            varStatus = "Em andamento";
        }
        Leilao leilao = new Leilao(leilaoDTO.getNomeLeilao(), leilaoDTO.getDataOcorrencia(), leilaoDTO.getDataVisitacao(), leilaoDTO.getLocal(), leilaoDTO.getEndereco(), leilaoDTO.getCidade(), leilaoDTO.getEstado(), varStatus);

        return leilaoRepository.save(leilao).toDTO();
    }

    // Consulta de todos os leilões
    public List<LeilaoDTO> listarLeiloes() {
        return leilaoRepository.findAll().stream().map(Leilao::toDTO).toList();
    }

    public List<LeilaoDTO> listagemLeiloesPorData() {
        return leilaoRepository.findAllByOrderByDataOcorrenciaAsc().stream().map(Leilao::toDTO).toList();
    }


    // Atualização de um leilão existente
    public LeilaoDTO atualizarLeilao(int idLeilao, LeilaoDTO leilaoDTO) {
        Optional<Leilao> leilaoOpt = leilaoRepository.findById(idLeilao);
        if (leilaoOpt.isPresent()) {
            Leilao leilao = leilaoOpt.get();
            leilao.setDataOcorrencia(leilaoDTO.getDataOcorrencia());
            leilao.setDataVisitacao(leilaoDTO.getDataVisitacao());
            leilao.setLocal(leilaoDTO.getLocal());
            leilao.setEndereco(leilaoDTO.getEndereco());
            leilao.setCidade(leilaoDTO.getCidade());
            leilao.setEstado(leilaoDTO.getEstado());
            leilao.setStatus(leilaoDTO.getStatus());
            return leilaoRepository.save(leilao).toDTO();
        }
        return null; // Ou lançar exceção
    }

    // Remoção de um leilão
    public void removerLeilao(int idLeilao) {
        leilaoRepository.deleteById(idLeilao);
    }
}
