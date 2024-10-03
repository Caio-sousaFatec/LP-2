package com.lp2.leilao.controllers;

import com.lp2.leilao.model.LoteRequest;
import com.lp2.leilao.services.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @PostMapping("/criar")
    public ResponseEntity<Object> criarLote(@RequestBody LoteRequest request) {
        Object lote = loteService.criarLote(request);
        return new ResponseEntity<>(lote, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Object>> listarLotes() {
        List<Object> lotes = loteService.listarLotes();
        return new ResponseEntity<>(lotes, HttpStatus.OK);
    }
}

