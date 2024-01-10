package com.SeuJogo.Steam.model.jogo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String username);
    //consultas usando Derived Query
    List<Usuario> findByCpf(String cpf);

}
