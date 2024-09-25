package com.lp2.leilao.Factory;

public interface LotesFactory {
    String criarLotes(String Nome, String Descricao, String Marca, String Modelo, String Cor, String Tipo,
            String Categoria,
            Double Lance);

}
