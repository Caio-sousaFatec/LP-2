package com.lp2.leilao.model.patterns;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;
    private Date dataInicio;
    private Date dataFim;

    @Transient
    private LeilaoState estado;


    public Leilao(String descricao, Date dataInicio, Date dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.estado = new EmAbertoState(); // Estado inicial
    }

    public Leilao() {

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
