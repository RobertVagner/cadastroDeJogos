package com.SeuJogo.Steam.model.jogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo,Long> {
    //implementar 1 consulta usando nativeQuery = true
    @Query(value = "SELECT * FROM jogos WHERE nome = ?1", nativeQuery = true)
    Jogo findByNomeNative(String nome);

    //implementar 2 consultas usando JPQL
    @Query("SELECT j FROM Jogo j WHERE j.preco > :preco")
    List<Jogo> findByPrecoGreaterThan(@Param("preco") Double preco);
}
