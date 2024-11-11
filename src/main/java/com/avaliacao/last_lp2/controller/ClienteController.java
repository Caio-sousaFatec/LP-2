package com.avaliacao.last_lp2.controller;

import com.avaliacao.last_lp2.dto.ClienteDTO;
import com.avaliacao.last_lp2.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Registrar um novo cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.registrarCliente(clienteDTO);
        return ResponseEntity.ok(novoCliente);
    }

    // Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    // Atualizar um cliente existente
    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable("idCliente") int idCliente, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.atualizarCliente(idCliente, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // Remover um cliente
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> removerCliente(@PathVariable("idCliente") int idCliente) {
        try {
            clienteService.removerCliente(idCliente);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


//todo: necessário resolver erro presente no delete, onde não remove id 0
