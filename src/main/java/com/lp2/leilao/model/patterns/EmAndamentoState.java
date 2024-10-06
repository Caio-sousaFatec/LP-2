package com.lp2.leilao.model.patterns;

import com.lp2.leilao.model.Leilao;

public class EmAndamentoState implements LeilaoState {

    @Override
    public void abrirLeilao(Leilao leilao) {
        System.out.println("Leilão já está em andamento.");
    }

    @Override
    public void iniciarLeilao(Leilao leilao) {
        System.out.println("Leilão já foi iniciado.");
    }

    @Override
    public void finalizarLeilao(Leilao leilao) {
        System.out.println("Finalizando o leilão...");
        leilao.setEstado(new FinalizadoState());
    }
}
