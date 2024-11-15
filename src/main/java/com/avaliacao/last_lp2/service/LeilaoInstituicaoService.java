package com.avaliacao.last_lp2.service;

import com.avaliacao.last_lp2.entity.LeilaoInstituicao;
import com.avaliacao.last_lp2.repository.LeilaoInstituicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeilaoInstituicaoService {

    @Autowired
    private LeilaoInstituicaoRepository leilaoInstituicaoRepository;

    // Busca todos os registros pelo ID do Leilão
    public List<LeilaoInstituicao> findByLeilaoId(int leilaoId) {
        return leilaoInstituicaoRepository.findByLeilao_IdLeilao(leilaoId);
    }

    // Busca todos os registros pelo ID da Instituição
    public List<LeilaoInstituicao> findByInstituicaoId(int instituicaoId) {
        return leilaoInstituicaoRepository.findByInstituicao_IdInstituicao(instituicaoId);
    }
}
