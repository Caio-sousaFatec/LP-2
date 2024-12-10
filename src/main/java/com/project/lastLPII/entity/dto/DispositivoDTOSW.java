package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.enums.TiposDispositivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDTOSW implements Serializable {
    private Long id;
    private String descricao;
    private Double valorInicial;
    private int loteId;
    private boolean vendido;
    private String nome;
    private TiposDispositivo tipo;
}