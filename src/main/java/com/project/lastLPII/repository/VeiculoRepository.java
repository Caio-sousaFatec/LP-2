package com.project.lastLPII.repository;

import com.project.lastLPII.entity.Veiculo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE VEICULO SET DESCRICAO = :descricao, VALOR_INICIAL = :valorInicial, VENDIDO = :vendido, LEILAO_ID = :leilaoId, MODELO = :modelo, MARCA = :marca, TIPO = :tipo WHERE ID = :id", nativeQuery = true)
    void updateById(
            @Param("descricao") String descricao,
            @Param("valorInicial") Double valorInicial,
            @Param("vendido") Boolean vendido,
            @Param("leilaoId") Long leilaoId,
            @Param("modelo") String modelo,
            @Param("marca") String marca,
            @Param("tipo") String tipo,
            @Param("id") Long id
    );

}