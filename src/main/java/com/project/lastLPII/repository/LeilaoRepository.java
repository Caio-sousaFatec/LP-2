package com.project.lastLPII.repository;

import com.project.lastLPII.entity.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Integer> {

    List<Leilao> findAllByOrderByDataOcorrenciaAsc();

}
