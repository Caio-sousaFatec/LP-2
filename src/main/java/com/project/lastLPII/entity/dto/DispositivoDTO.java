package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.enums.TiposDispositivo;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDTO implements Serializable {
    private Long id;
    private String descricao;
    private Double valorInicial;
    private LoteDTO loteId;
    private boolean vendido;
    private String nome;
    private TiposDispositivo tipo;
}