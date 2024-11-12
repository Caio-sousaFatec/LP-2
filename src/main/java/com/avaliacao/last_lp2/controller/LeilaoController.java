package com.avaliacao.last_lp2.controller;

import com.avaliacao.last_lp2.dto.LeilaoDTO;
import com.avaliacao.last_lp2.service.LeilaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leiloes")
public class LeilaoController {

    private final LeilaoService leilaoService;

    public LeilaoController(LeilaoService leilaoService) {
        this.leilaoService = leilaoService;
    }

    // Registrar um novo leilão
    @PostMapping
    public ResponseEntity<LeilaoDTO> registrarLeilao(@RequestBody LeilaoDTO leilaoDTO) {
        LeilaoDTO novoLeilao = leilaoService.registrarLeilao(leilaoDTO);
        return ResponseEntity.ok(novoLeilao);
    }

    // Listar todos os leilões
    @GetMapping
    public ResponseEntity<List<LeilaoDTO>> listarLeiloes() {
        List<LeilaoDTO> leiloes = leilaoService.listarLeiloes();
        return ResponseEntity.ok(leiloes);
    }

    //listagem por datas
    @GetMapping("/ordenados-por-data")
    public List<LeilaoDTO> listarLeiloesPorData() {
        return leilaoService.listagemLeiloesPorData();
    }

    // Atualizar um leilão existente
    @PutMapping("/{idLeilao}")
    public ResponseEntity<LeilaoDTO> atualizarLeilao(@PathVariable("idLeilao") int idLeilao, @RequestBody LeilaoDTO leilaoDTO) {
        LeilaoDTO leilaoAtualizado = leilaoService.atualizarLeilao(idLeilao, leilaoDTO);
        return ResponseEntity.ok(leilaoAtualizado);
    }

    // Remover um leilão
    @DeleteMapping("/{idLeilao}")
    public ResponseEntity<Void> removerLeilao(@PathVariable("idLeilao") int idLeilao) {
        leilaoService.removerLeilao(idLeilao);
        return ResponseEntity.noContent().build();
    }
}

