package com.lp2.leilao.model;


import com.lp2.leilao.Patterns.Leilao;


public class Dispositivo {
    private String nome;
    private String descricao;
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;
    private Leilao leilao;

    public Dispositivo(String nome, String descricao, String marca, String modelo, String cor, Integer lance, Leilao leilao) {
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.lance = lance;
        this.leilao = leilao;
    }

    @Override
    public String toString() {
        return "Dispositivo: " + nome + ", Marca: " + marca + ", Lance: R$" + lance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getLance() {
        return lance;
    }

    public void setLance(Integer lance) {
        this.lance = lance;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }
}
