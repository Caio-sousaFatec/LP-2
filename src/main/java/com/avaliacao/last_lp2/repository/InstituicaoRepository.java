package com.avaliacao.last_lp2.repository;

import com.avaliacao.last_lp2.entity.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

    // Buscar instituição por CNPJ
    Optional<Instituicao> findByCnpj(String cnpj);

    // Outros métodos padrão do JpaRepository já incluem save(), delete(), findById(), etc.
}
