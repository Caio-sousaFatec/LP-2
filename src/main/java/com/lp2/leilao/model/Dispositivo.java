package com.lp2.leilao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.lp2.leilao.model.patterns.Leilao;

@Setter
@Getter
@Entity
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;
    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;
    private String tipo;

    // Public no-argument constructor
    public Dispositivo() {
    }

    // Constructor with all parameters
    public Dispositivo(String nome, String descricao, String marca, String modelo, String cor, Integer lance, Leilao leilao, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.lance = lance;
        this.leilao = leilao;
        this.tipo = tipo;
    }
}