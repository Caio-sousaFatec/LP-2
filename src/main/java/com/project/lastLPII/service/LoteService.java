package com.project.lastLPII.service;

import com.project.lastLPII.entity.dto.LanceDTO;
import com.project.lastLPII.entity.dto.LeilaoDTO;
import com.project.lastLPII.entity.dto.LoteDTO;
import com.project.lastLPII.entity.Leilao;
import com.project.lastLPII.entity.Lote;
import com.project.lastLPII.repository.LanceRepository;
import com.project.lastLPII.repository.LeilaoRepository;
import com.project.lastLPII.repository.LoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoteService {

    private final LoteRepository loteRepository;
    private final LeilaoRepository leilaoRepository;
    private final ModelMapper modelMapper;
    private final LeilaoService leilaoService;
    private final LanceRepository lanceRepository;

    public LoteService(LoteRepository loteRepository, LeilaoRepository leilaoRepository,
                       ModelMapper modelMapper, LeilaoService leilaoService, LanceRepository lanceRepository) {
        this.loteRepository = loteRepository;
        this.leilaoRepository = leilaoRepository;
        this.modelMapper = modelMapper;
        this.leilaoService = leilaoService;
        this.lanceRepository = lanceRepository;
    }

    public LoteDTO getLoteById(Long id) {
        return loteRepository.findById(Math.toIntExact(id)).map((element) -> modelMapper.map(element, LoteDTO.class)).get();
    }

    public LoteDTO registrarLote(LoteDTO loteDTO) {
        if (loteDTO.getLeilaoDTO().getIdLeilao().get() != 0) {
            Optional<Leilao> leilaoOpt = leilaoRepository.findById(loteDTO.getLeilaoDTO().getIdLeilao().get());
            if (leilaoOpt.isPresent()) {
                Lote lote = modelMapper.map(loteDTO, Lote.class);
                return modelMapper.map(loteRepository.save(lote), LoteDTO.class);
            }
            return null;
        }
        return null;
    }

    public List<LoteDTO> listarLotes() {
        return loteRepository.findAll().stream().map((element) -> modelMapper.map(element, LoteDTO.class)).toList();
    }

    public List<LoteDTO> listarLotesEntreLances(double min, double max, int idLeilao) {
        List<LoteDTO> loteDTOList = loteRepository.findByLanceInicialBetween(min, max, idLeilao).stream().map((element) -> modelMapper.map(element, LoteDTO.class)).toList();
        loteDTOList.stream().forEach((element) -> element.setLeilaoDTO(modelMapper.map(leilaoRepository.findById(idLeilao).get(), LeilaoDTO.class)));
        return loteDTOList;
    }

    public List<LoteDTO> listarLotesEntreLancesTotais(double min, double max, int idLeilao) {
        List<Lote> lotes = loteRepository.findLotesByLancesTotaisBetween(min, max, idLeilao);
        return lotes.stream()
                .map(lote -> modelMapper.map(lote, LoteDTO.class))
                .toList();
    }


    public LoteDTO atualizarLote(int idLote, LoteDTO loteDTO) {
        Optional<Lote> loteOpt = loteRepository.findById(idLote);
        if (loteOpt.isPresent()) {
            Lote lote = loteOpt.get();
            lote.setTipo(loteDTO.getTipo());
            lote.setNome(loteDTO.getNome());
            lote.setDescricao(loteDTO.getDescricao());
            lote.setLanceInicial(loteDTO.getLanceInicial());
            return modelMapper.map(loteRepository.save(lote), LoteDTO.class);
        }
        return null;
    }

    public Optional<List<LoteDTO>> getByWord(String palavraBusca) {
        return Optional.of(loteRepository.findByNomeContainingIgnoreCase(palavraBusca).stream().map((element) -> modelMapper.map(element, LoteDTO.class)).collect(Collectors.toList()));
    }

    public Optional<List<LoteDTO>> getByType(String tipoBusca) {
        return Optional.of(loteRepository.findByTipoContainingIgnoreCase(tipoBusca).stream().map((element) -> modelMapper.map(element, LoteDTO.class)).collect(Collectors.toList()));
    }

    public void removerLote(int idLote) {
        loteRepository.deleteById(idLote);
    }
}

