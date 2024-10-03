package com.lp2.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lp2.leilao.model.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
}