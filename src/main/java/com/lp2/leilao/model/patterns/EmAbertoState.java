package com.lp2.leilao.model.patterns;

import com.lp2.leilao.model.Leilao;

public class EmAbertoState implements LeilaoState {

    @Override
    public void abrirLeilao(Leilao leilao) {
        System.out.println("Leilão já está em aberto.");
    }

    @Override
    public void iniciarLeilao(Leilao leilao) {
        System.out.println("Iniciando o leilão...");
        leilao.setEstado(new EmAndamentoState());
    }

    @Override
    public void finalizarLeilao(Leilao leilao) {
        System.out.println("Leilão não pode ser finalizado antes de iniciar.");
    }
}
