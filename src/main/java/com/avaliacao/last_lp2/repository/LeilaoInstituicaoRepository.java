package com.avaliacao.last_lp2.repository;

import com.avaliacao.last_lp2.entity.LeilaoInstituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeilaoInstituicaoRepository extends JpaRepository<LeilaoInstituicao, Integer> {

    List<LeilaoInstituicao> findByLeilao_IdLeilao(int leilaoId);

    List<LeilaoInstituicao> findByInstituicao_IdInstituicao(int instituicaoId);
}
