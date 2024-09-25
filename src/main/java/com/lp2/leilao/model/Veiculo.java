package com.lp2.leilao.model;

import com.lp2.leilao.Patterns.LotesFactory;
import com.lp2.leilao.Patterns.Leilao;
import jakarta.persistence.*;

public class Veiculo {
    private String nome;
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;
    private Leilao leilao;

    public Veiculo(String nome, String marca, String modelo, String cor, Integer lance, Leilao leilao) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.lance = lance;
        this.leilao = leilao;
    }

    @Override
    public String toString() {
        return "Veículo: " + nome + ", Marca: " + marca + ", Lance: R$" + lance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    // Getters e Setters
}




