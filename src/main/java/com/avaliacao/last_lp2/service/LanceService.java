package com.avaliacao.last_lp2.service;

import com.avaliacao.last_lp2.dto.LanceDTO;
import com.avaliacao.last_lp2.entity.Cliente;
import com.avaliacao.last_lp2.entity.Lance;
import com.avaliacao.last_lp2.entity.Lote;
import com.avaliacao.last_lp2.repository.ClienteRepository;
import com.avaliacao.last_lp2.repository.LanceRepository;
import com.avaliacao.last_lp2.repository.LoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanceService {

    private final LanceRepository lanceRepository;
    private final ClienteRepository clienteRepository;
    private final LoteRepository loteRepository;

    public LanceService(LanceRepository lanceRepository, ClienteRepository clienteRepository, LoteRepository loteRepository) {
        this.lanceRepository = lanceRepository;
        this.clienteRepository = clienteRepository;
        this.loteRepository = loteRepository;
    }

    // Registrar um lance para um lote
    public LanceDTO registrarLance(LanceDTO lanceDTO) {
        Optional<Cliente> clienteOpt = clienteRepository.findByCpf(lanceDTO.getCliente().getCpf());
        Optional<Lote> loteOpt = loteRepository.findById(lanceDTO.getLote().getId());
        if (clienteOpt.isPresent() && loteOpt.isPresent()) {
            Lance lance = new Lance(lanceDTO.getValor(), clienteOpt.get(), loteOpt.get());
            return lanceRepository.save(lance).toDTO();
        }
        return null; // Ou lançar exceção
    }

    // Consulta dos lances de um determinado lote
    public List<LanceDTO> consultarLancesPorLote(int idLote) {
        return lanceRepository.findByLoteId(idLote).stream().map(Lance::toDTO).toList();
    }
}

