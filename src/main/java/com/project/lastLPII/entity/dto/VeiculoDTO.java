package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.enums.TiposVeiculos;
import lombok.Data;

@Data
public class VeiculoDTO {
    private Long id;
    private String descricao;
    private Double valorInicial;
    private boolean vendido;
    private String modelo;
    private String marca;
    private TiposVeiculos tipo;
}
