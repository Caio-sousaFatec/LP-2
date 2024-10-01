package com.lp2.leilao.services;

import com.lp2.leilao.model.patterns.*;
import com.lp2.leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    // Criação de um leilão
    public Leilao criarLeilao(Leilao leilao) {
        leilao.setEstado(new EmAbertoState());
        return leilaoRepository.save(leilao);
    }

    // Abrir leilão
    public void abrirLeilao(Long id) {
        Leilao leilao = leilaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Leilão não encontrado"));
        leilao.abrirLeilao();
        leilaoRepository.save(leilao);
    }

    // Iniciar leilão
    public void iniciarLeilao(Long id) {
        Leilao leilao = leilaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Leilão não encontrado"));
        leilao.iniciarLeilao();
        leilaoRepository.save(leilao);
    }

    // Finalizar leilão
    public void finalizarLeilao(Long id) {
        Leilao leilao = leilaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Leilão não encontrado"));
        leilao.finalizarLeilao();
        leilaoRepository.save(leilao);
    }

    // Listar todos os leilões
    public List<Leilao> listarLeiloes() {
        return leilaoRepository.findAll();
    }
}
