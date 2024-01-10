package com.SeuJogo.Steam.controller;

import com.SeuJogo.Steam.model.jogo.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class usuarioController {
    @Autowired
    private UsuarioRepository repositoryUsuario;

    @GetMapping("/dados")
    public String carregaPaginaUsuario(Long idusuario, Model model){
        if(idusuario != null)
        {
            Usuario u1 = repositoryUsuario.getReferenceById(idusuario);
            model.addAttribute("usuario",u1);
        }
        return "/usuario/dados";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repositoryUsuario.findAll());
        return "/usuario/listagem";
    }
    @PostMapping
    public String cadastraUsuario(DadosCadastroUsuario u){
        Usuario u1 = new Usuario(u);
        repositoryUsuario.save(u1);
        return "redirect:/usuario/dados";
    }

    @DeleteMapping
    @Transactional
    public String removeUsuario(Long idusuario){
        repositoryUsuario.deleteById(idusuario);
        return "redirect:/usuario/listagem";
    }

    @PutMapping
    @Transactional
    public String alteraUsuario(DadosAlteraUsuario d){
        Usuario j1 = repositoryUsuario.getReferenceById(d.idusuario());
        j1.atualizaDados(d);
        return "usuario/dados";
    }

    //2 consultas usando Derived Query
    @GetMapping("/buscarPorCpf")
    public String buscarPorCpf(@RequestParam(required = false) String cpf, Model model) {
        if (cpf != null) {
            List<Usuario> usuarios = repositoryUsuario.findByCpf(cpf);
            model.addAttribute("usuarios", usuarios);
        }
        return "/usuario/buscarPorCpf";
    }


}
