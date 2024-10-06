package com.lp2.leilao.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;

    public Cliente() {
    }

    public Cliente(long id, String nome, String email, String senha, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

}
