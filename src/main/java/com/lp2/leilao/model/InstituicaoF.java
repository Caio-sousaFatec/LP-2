package com.lp2.leilao.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class InstituicaoF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;

    @ManyToMany(mappedBy = "leiloes" )
    private List<Leilao> leiloes;

    public InstituicaoF() {
    }

    public InstituicaoF(Long id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }
}
