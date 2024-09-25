package com.lp2.leilao.Patterns;

public interface LotesFactory {
    String criaLotes(String nome, String descricao, String marca, String modelo, String cor, String tipo,Integer lance ,String categoria,Leilao leilao);
}
