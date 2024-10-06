package com.lp2.leilao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Historico {

    @Id
    private long id;
    private String descricao;
    private String data;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;
    @ManyToOne
    @JoinColumn(name = "lance_id")
    private Lance lance;

    public Historico() {
    }

    public Historico (long id, String descricao, String data, Cliente cliente, Leilao leilao, Lance lance) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.cliente = cliente;
        this.leilao = leilao;
        this.lance = lance;
    }

}
