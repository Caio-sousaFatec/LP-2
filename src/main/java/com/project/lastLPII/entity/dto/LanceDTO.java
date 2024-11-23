package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.Cliente;
import com.project.lastLPII.entity.Lote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanceDTO {
    private Double valor;
    private Cliente cliente;
    private Lote lote;
}

