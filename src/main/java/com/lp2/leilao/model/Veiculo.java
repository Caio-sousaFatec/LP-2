package com.lp2.leilao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    private String tipo;

    // Public no-argument constructor
    public Veiculo() {
    }

    // Constructor with all parameters except id
    public Veiculo(String nome, String marca, String modelo, String cor, Integer lance, Leilao leilao, String tipo) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.lance = lance;
        this.leilao = leilao;
        this.tipo = tipo;
    }
}