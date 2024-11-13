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
    @JoinColumn(name = "idLeilao")
    private int idLeilao;
    @ManyToOne(targetEntity = Instituicao.class)
    @JoinColumn(name = "idInstituicao")
    private int idInstituicao;
}
