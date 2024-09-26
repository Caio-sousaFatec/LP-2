package com.lp2.leilao.model;


import com.lp2.leilao.Patterns.Leilao;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Dispositivo {
    private String nome;
    private String descricao;
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;
    private Leilao leilao;
    private String tipo;

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

    @Override
    public String toString() {
        return "Dispositivo: " + nome + ", Marca: " + marca + ", Lance: R$" + lance;
    }

}
