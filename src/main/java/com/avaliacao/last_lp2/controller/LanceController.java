package com.avaliacao.last_lp2.controller;

import com.avaliacao.last_lp2.dto.LanceDTO;
import com.avaliacao.last_lp2.service.LanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lances")
public class LanceController {

    private final LanceService lanceService;

    public LanceController(LanceService lanceService) {
        this.lanceService = lanceService;
    }

    // Registrar um novo lance
    @PostMapping
    public ResponseEntity<LanceDTO> registrarLance(@RequestBody LanceDTO lanceDTO) {
        LanceDTO novoLance = lanceService.registrarLance(lanceDTO);
        return ResponseEntity.ok(novoLance);
    }

    // Consultar lances por lote
    @GetMapping("/lote/{idLote}")
    public ResponseEntity<List<LanceDTO>> consultarLancesPorLote(@PathVariable int idLote) {
        List<LanceDTO> lances = lanceService.consultarLancesPorLote(idLote);
        return ResponseEntity.ok(lances);
    }
}

