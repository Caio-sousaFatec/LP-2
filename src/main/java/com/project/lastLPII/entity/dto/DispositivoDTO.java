package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.enums.TiposDispositivo;
import lombok.Data;

import java.io.Serializable;

@Data
public class DispositivoDTO implements Serializable {
    private Long id;
    private String descricao;
    private Double valorInicial;
    private boolean vendido;
    private String nome;
    private TiposDispositivo tipo;
}