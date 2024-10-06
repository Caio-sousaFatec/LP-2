package com.lp2.leilao.services;

import com.lp2.leilao.model.Dispositivo;
import com.lp2.leilao.model.LoteRequest;
import com.lp2.leilao.model.Veiculo;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.repository.DispositivoRepository;
import com.lp2.leilao.repository.LeilaoRepository;
import com.lp2.leilao.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoteService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public Object criarLote(LoteRequest request) {
        Leilao leilao = leilaoRepository.findById(request.getLeilaoId())
                .orElseThrow(() -> new RuntimeException("Leilão não encontrado"));

        Object lote;
        if ("dispositivo".equalsIgnoreCase(request.getTipo())) {
            lote = new Dispositivo(
                    request.getNome(),
                    request.getDescricao(),
                    request.getMarca(),
                    request.getModelo(),
                    request.getCor(),
                    request.getLance(),
                    leilao,
                    request.getTipo()
            );
            dispositivoRepository.save((Dispositivo) lote);
        } else if ("veiculo".equalsIgnoreCase(request.getTipo())) {
            lote = new Veiculo(
                    request.getNome(),
                    request.getMarca(),
                    request.getModelo(),
                    request.getCor(),
                    request.getLance(),
                    leilao,
                    request.getTipo()
            );
            veiculoRepository.save((Veiculo) lote);
        } else {
            throw new IllegalArgumentException("Tipo de lote inválido: " + request.getTipo());
        }

        return lote;
    }

    public List<Object> listarLotes() {
        List<Object> lotes = new ArrayList<>();
        lotes.addAll(veiculoRepository.findAll());
        lotes.addAll(dispositivoRepository.findAll());
        return lotes;
    }
}
