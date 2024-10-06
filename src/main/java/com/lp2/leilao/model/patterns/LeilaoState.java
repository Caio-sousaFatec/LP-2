package com.lp2.leilao.model.patterns;

import com.lp2.leilao.model.Leilao;

public interface LeilaoState {
    void abrirLeilao(Leilao leilao);
    void iniciarLeilao(Leilao leilao);
    void finalizarLeilao(Leilao leilao);
}

