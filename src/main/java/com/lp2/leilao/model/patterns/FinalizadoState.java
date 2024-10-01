package com.lp2.leilao.model.patterns;

public class FinalizadoState implements LeilaoState {

    @Override
    public void abrirLeilao(Leilao leilao) {
        System.out.println("Leilão já foi finalizado.");
    }

    @Override
    public void iniciarLeilao(Leilao leilao) {
        System.out.println("Leilão já foi finalizado e não pode ser reiniciado.");
    }

    @Override
    public void finalizarLeilao(Leilao leilao) {
        System.out.println("Leilão já foi finalizado.");
    }
}

