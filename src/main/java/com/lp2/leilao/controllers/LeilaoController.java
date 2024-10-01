package com.lp2.leilao.controllers;

import com.lp2.leilao.model.patterns.Leilao;
import com.lp2.leilao.services.LeilaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leiloes")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    // Endpoint para criar um novo leilão
    @PostMapping("/criar")
    public ResponseEntity<Leilao> criarLeilao(@RequestBody Leilao leilao) {
        Leilao novoLeilao = leilaoService.criarLeilao(leilao);
        return new ResponseEntity<>(novoLeilao, HttpStatus.CREATED);
    }

    // Endpoint para abrir um leilão
    @PutMapping("/{id}/abrir")
    public ResponseEntity<String> abrirLeilao(@PathVariable Long id) {
        leilaoService.abrirLeilao(id);
        return new ResponseEntity<>("Leilão aberto com sucesso!", HttpStatus.OK);
    }

    // Endpoint para iniciar um leilão
    @PutMapping("/{id}/iniciar")
    public ResponseEntity<String> iniciarLeilao(@PathVariable Long id) {
        leilaoService.iniciarLeilao(id);
        return new ResponseEntity<>("Leilão iniciado com sucesso!", HttpStatus.OK);
    }

    // Endpoint para finalizar um leilão
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<String> finalizarLeilao(@PathVariable Long id) {
        leilaoService.finalizarLeilao(id);
        return new ResponseEntity<>("Leilão finalizado com sucesso!", HttpStatus.OK);
    }

    // Endpoint para buscar todos os leilões
    @GetMapping
    public ResponseEntity<List<Leilao>> listarLeiloes() {
        List<Leilao> leiloes = leilaoService.listarLeiloes();
        return new ResponseEntity<>(leiloes, HttpStatus.OK);
    }
}
