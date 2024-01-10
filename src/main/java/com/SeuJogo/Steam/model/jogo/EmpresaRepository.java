package com.SeuJogo.Steam.model.jogo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
    //consultas usando Derived Query
    List<Empresa> findByNomeEmpresa(String nomeEmpresa);
}
