package com.lp2.leilao.model.patterns;

import com.lp2.leilao.model.Dispositivo;
import com.lp2.leilao.model.Veiculo;

    public abstract class LoteFactory {

        public static Object criarLote(String nome, String descricao, String marca, String modelo, String cor, Integer lance, Leilao leilao, String tipo) {
            if ("dispositivo".equalsIgnoreCase(tipo)) {
                return new Dispositivo(nome, descricao, marca, modelo, cor, lance, leilao, tipo);
            } else if ("veiculo".equalsIgnoreCase(tipo)) {
                return new Veiculo(nome, marca, modelo, cor, lance, leilao, tipo);
            }
            throw new IllegalArgumentException("Tipo de lote inválido: " + tipo);
        }
    }

