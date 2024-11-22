package com.project.last_lpII.entity.dto;

import com.project.last_lpII.entity.TiposVeiculos;
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
