package com.project.last_lpII.entity.dto;

import com.project.last_lpII.entity.TiposDispositivo;
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