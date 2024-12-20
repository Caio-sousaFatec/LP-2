package com.project.lastLPII.entity.dto;

import com.project.lastLPII.entity.enums.LeilaoStatusTypes;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeilaoDetalhadoDto {
    private int id;
    private LocalDateTime dataOcorrencia;
    private LocalDateTime dataVisita;
    private String endereco;
    private String cidade;
    private String estado;
    private List<LoteDTO> produtos;
    private List<InstituicaoDTO> instituicoesFinanceiras;
    private LeilaoStatusTypes status;
}
