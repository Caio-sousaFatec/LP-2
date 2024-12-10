package com.project.lastLPII.entity.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoteTipoDto implements Serializable {
    Integer id;
    Integer idLote;
    Integer idVeiculo;
    Integer idDispositivo;
}