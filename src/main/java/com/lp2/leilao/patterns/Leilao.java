package com.lp2.leilao.patterns;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class Leilao {
    private LeilaoState estado;
    private String descricao;
    private Date dataInicio;
    private Date dataFim;

    public Leilao(String descricao, Date dataInicio, Date dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.estado = new EmAbertoState(); // Estado inicial
    }

    public void abrirLeilao() {
        estado.abrirLeilao(this);
    }

    public void iniciarLeilao() {
        estado.iniciarLeilao(this);
    }

    public void finalizarLeilao() {
        estado.finalizarLeilao(this);
    }

}
