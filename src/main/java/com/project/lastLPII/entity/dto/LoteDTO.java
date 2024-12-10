package com.project.lastLPII.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoteDTO {
    private Integer id;
    private String nome;
    private String descricao;
    private Double lanceInicial;
    private LeilaoDTO leilaoDTO;
    private LoteTipoDto loteTipoDTO;
}
