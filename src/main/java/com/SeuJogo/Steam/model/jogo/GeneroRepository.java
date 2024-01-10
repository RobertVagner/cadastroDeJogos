package com.SeuJogo.Steam.model.jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GeneroRepository extends JpaRepository<Genero,Long> {
    //implementar 2 consultas usando JPQL
    @Query("SELECT j FROM Genero j WHERE j.nomeGenero = :nomeGenero")
    Genero findByNomeGenero(@Param("nomeGenero") String nome);
}
