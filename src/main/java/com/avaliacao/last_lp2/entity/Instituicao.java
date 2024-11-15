package com.avaliacao.last_lp2.entity;

import com.avaliacao.last_lp2.dto.InstituicaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instituicao")
    private int idInstituicao;
    private String nome;
    private String cnpj;

    public Instituicao(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public InstituicaoDTO toDTO() {
        InstituicaoDTO instituicaoDTO = new InstituicaoDTO();
        instituicaoDTO.setNome(this.nome);
        instituicaoDTO.setCnpj(this.cnpj);
        return instituicaoDTO;
    }
}
