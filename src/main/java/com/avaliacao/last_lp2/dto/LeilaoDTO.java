package com.avaliacao.last_lp2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class LeilaoDTO {
    private Integer id;
    private String nomeLeilao;
    private LocalDate dataOcorrencia;
    private LocalDate dataVisitacao;
    private String local;
    private String endereco;
    private String cidade;
    private String estado;
    private String status;

    public LeilaoDTO(String nomeLeilao, LocalDate dataOcorrencia, LocalDate dataVisitacao, String local, String endereco, String cidade, String estado, String status) {
        this.nomeLeilao = nomeLeilao;
        this.dataOcorrencia = dataOcorrencia;
        this.dataVisitacao = dataVisitacao;
        this.local = local;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
    }
}


