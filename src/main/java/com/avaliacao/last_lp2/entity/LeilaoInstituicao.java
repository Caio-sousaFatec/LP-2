package com.avaliacao.last_lp2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeilaoInstituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Leilao.class)
    @JoinColumn(name = "id_leilao")
    private Leilao leilao;

    @ManyToOne(targetEntity = Instituicao.class)
    @JoinColumn(name = "id_instituicao")
    private Instituicao instituicao;
}
