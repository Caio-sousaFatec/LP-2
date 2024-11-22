package com.project.last_lpII.repository;

import com.project.last_lpII.entity.Lance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Integer> {

    @Query(value = "SELECT * FROM LANCE WHERE ID_LOTE = :idLote", nativeQuery = true)
    List<Lance> findByLoteId(@Param("idLote") int idLote);


    @Query(value = "SELECT * FROM LANCE WHERE ID_LOTE in (SELECT LOTE.ID_LOTE FROM LOTE WHERE ID_LEILAO = :leilaoId)", nativeQuery = true)
    List<Lance> findAllByLeilaoId(@Param("leilaoId") Integer leilaoId);
}
