package com.lp2.leilao.patterns;

public interface LeilaoState {
    void abrirLeilao(Leilao leilao);
    void iniciarLeilao(Leilao leilao);
    void finalizarLeilao(Leilao leilao);
}

