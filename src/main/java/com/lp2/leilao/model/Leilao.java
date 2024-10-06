package com.lp2.leilao.model;

import com.lp2.leilao.model.patterns.EmAbertoState;
import com.lp2.leilao.model.patterns.LeilaoState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "leilao")
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leilao_id", unique = true)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "leilao_cliente",
            joinColumns = @JoinColumn(name = "leilao_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> cliente;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Transient
    private LeilaoState estado;


    public Leilao(String descricao, Date dataInicio, Date dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.estado = new EmAbertoState(); // Estado inicial
    }

    public Leilao() {

    }

    public void abrirLeilao() {
        estado.abrirLeilao(this);
    }

    public void iniciarLeilao() {
        estado.iniciarLeilao(this);
    }

    public void finalizarLeilao() {
        estado.finalizarLeilao(this);
    }

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "leilao_instituicao",
            joinColumns = @JoinColumn(name = "leilao_id"),
            inverseJoinColumns = @JoinColumn(name = "instituicao_id")
    )
    private List<InstituicaoF> leiloes;


}