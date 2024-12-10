package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.enums.TiposVeiculos;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
    private Long id;
    private String descricao;
    private Double valorInicial;
    private boolean vendido;
    private LoteDTO loteId;
    private String modelo;
    private String marca;
    private TiposVeiculos tipo;
}
