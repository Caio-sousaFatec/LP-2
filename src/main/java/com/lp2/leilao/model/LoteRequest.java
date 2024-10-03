package com.lp2.leilao.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoteRequest {
    private String nome;
    private String descricao;  // Para dispositivos
    private String marca;
    private String modelo;
    private String cor;
    private Integer lance;
    private Long leilaoId;  // ID do leilão ao qual o lote pertence
    private String tipo;    // "dispositivo" ou "veiculo"
}
