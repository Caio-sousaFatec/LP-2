package com.avaliacao.last_lp2.service;

import com.avaliacao.last_lp2.dto.ClienteDTO;
import com.avaliacao.last_lp2.entity.Cliente;
import com.avaliacao.last_lp2.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Registro de um novo cliente
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente(clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getEmail(), clienteDTO.getTelefone());
        return clienteRepository.save(cliente).toDTO();
    }

    // Consulta de todos os clientes
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream().map(Cliente::toDTO).toList();
    }

    // Atualização de um cliente existente
    public ClienteDTO atualizarCliente(int idCliente, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(idCliente);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setTelefone(clienteDTO.getTelefone());
            return clienteRepository.save(cliente).toDTO();
        }
        return null; // Ou lançar exceção
    }

    // Remoção de um cliente
    public void removerCliente(int idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            throw new EntityNotFoundException("Cliente com ID " + idCliente + " não encontrado.");
        }
        clienteRepository.deleteById(idCliente);
    }

}
