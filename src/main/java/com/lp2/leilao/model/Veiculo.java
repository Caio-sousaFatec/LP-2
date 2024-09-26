package com.lp2.leilao.model;

import com.lp2.leilao.Patterns.Leilao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Veiculo {
    private String nome;
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;
    private Leilao leilao;
    private String tipo;


    public Veiculo(String nome, String marca, String modelo, String cor, Integer lance, Leilao leilao, String tipo) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.lance = lance;
        this.leilao = leilao;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Veículo: " + nome + ", Marca: " + marca + ", Lance: R$" + lance;
    }


}




