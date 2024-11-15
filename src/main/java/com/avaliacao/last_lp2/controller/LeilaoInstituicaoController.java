package com.avaliacao.last_lp2.controller;

import com.avaliacao.last_lp2.entity.LeilaoInstituicao;
import com.avaliacao.last_lp2.service.LeilaoInstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeilaoInstituicaoController {

    @Autowired
    private LeilaoInstituicaoService leilaoInstituicaoService;

    // Corrigido para aceitar ID via URL e usar o serviço para buscar registros
    @GetMapping("/leilaoInstituicao/leilao/{idLeilao}")
    public List<LeilaoInstituicao> findByLeilaoId(@PathVariable("idLeilao") int leilaoId) {
        // Chama o serviço para buscar registros pelo ID do Leilão
        return leilaoInstituicaoService.findByLeilaoId(leilaoId);
    }

    // Corrigido para aceitar ID via URL e usar o serviço para buscar registros
    @GetMapping("/leilaoInstituicao/instituicao/{idInstituicao}")
    public List<LeilaoInstituicao> findByInstituicaoId(@PathVariable("idInstituicao") int instituicaoId) {
        // Chama o serviço para buscar registros pelo ID da Instituição
        return leilaoInstituicaoService.findByInstituicaoId(instituicaoId);
    }
}
