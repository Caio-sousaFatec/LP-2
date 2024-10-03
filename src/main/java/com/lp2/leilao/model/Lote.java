package com.lp2.leilao.model;

import com.lp2.leilao.model.patterns.Leilao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Para que cada subclasse tenha sua própria tabela
public abstract class Lote {

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

}
