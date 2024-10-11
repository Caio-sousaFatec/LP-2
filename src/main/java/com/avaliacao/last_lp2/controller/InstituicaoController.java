package com.avaliacao.last_lp2.controller;

import com.avaliacao.last_lp2.dto.InstituicaoDTO;
import com.avaliacao.last_lp2.service.InstituicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituicoes")
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    public InstituicaoController(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    // Registrar uma nova instituição financeira
    @PostMapping
    public ResponseEntity<InstituicaoDTO> registrarInstituicao(@RequestBody InstituicaoDTO instituicaoDTO) {
        InstituicaoDTO novaInstituicao = instituicaoService.registrarInstituicao(instituicaoDTO);
        return ResponseEntity.ok(novaInstituicao);
    }

    // Listar todas as instituições financeiras
    @GetMapping
    public ResponseEntity<List<InstituicaoDTO>> listarInstituicoes() {
        List<InstituicaoDTO> instituicoes = instituicaoService.listarInstituicoes();
        return ResponseEntity.ok(instituicoes);
    }

    // Atualizar uma instituição financeira existente
    @PutMapping("/{idInstituicao}")
    public ResponseEntity<InstituicaoDTO> atualizarInstituicao(@PathVariable int idInstituicao, @RequestBody InstituicaoDTO instituicaoDTO) {
        InstituicaoDTO instituicaoAtualizada = instituicaoService.atualizarInstituicao(idInstituicao, instituicaoDTO);
        return ResponseEntity.ok(instituicaoAtualizada);
    }

    // Remover uma instituição financeira
    @DeleteMapping("/{idInstituicao}")
    public ResponseEntity<Void> removerInstituicao(@PathVariable int idInstituicao) {
        instituicaoService.removerInstituicao(idInstituicao);
        return ResponseEntity.noContent().build();
    }
}

