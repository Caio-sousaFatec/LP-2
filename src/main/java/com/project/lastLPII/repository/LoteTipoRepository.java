package com.project.lastLPII.repository;

import com.project.lastLPII.entity.LoteTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteTipoRepository extends JpaRepository<LoteTipo, Integer> {
}