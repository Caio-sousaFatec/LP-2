package com.avaliacao.last_lp2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstituicaoDTO {
    private int id;
    private String nome;
    private String cnpj;

    public InstituicaoDTO(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
}
