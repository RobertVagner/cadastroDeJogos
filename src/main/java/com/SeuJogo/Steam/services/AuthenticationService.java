package com.SeuJogo.Steam.services;

import com.SeuJogo.Steam.model.jogo.Usuario;
import com.SeuJogo.Steam.model.jogo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationService {
    @Autowired
    private UsuarioRepository loginRepository;

    public boolean authenticate(String username, String senha) {
        Usuario user = loginRepository.findByUsername(username);

        return user != null && user.getSenha().equals(senha);
    }

}
