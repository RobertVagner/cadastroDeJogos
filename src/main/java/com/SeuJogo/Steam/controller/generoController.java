package com.SeuJogo.Steam.controller;

import com.SeuJogo.Steam.model.jogo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/generos")
public class generoController {
    @Autowired
    private GeneroRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaGenero(Long idgenero, Model model){
        if(idgenero != null)
        {
            Genero e1 = repository.getReferenceById(idgenero);
            model.addAttribute("genero",e1);
        }
        return "/generos/formulario";
    }
    @PostMapping
    public String cadastraGenero(DadosCadastroGenero dados){
        Genero g1 = new Genero(dados);
        repository.save(g1);
        return "redirect:/generos/formulario";
    }
    @GetMapping("/listagem")
    public String carregaListagemGenero(Model model){
        model.addAttribute("lista",repository.findAll());
        return "generos/listagem";
    }
    @DeleteMapping
    @Transactional
    public String removeGenero(Long idgenero){
        repository.deleteById(idgenero);
        return "redirect:/generos/listagem";
    }

    @PutMapping
    @Transactional
    public String alteraGenero(DadosAlteraGenero d){
        Genero e1 = repository.getReferenceById(d.idgenero());
        e1.atualizaDados(d);
        return "generos/formulario";
    }
    //implementar 2 consultas usando JPQL
    @GetMapping("/buscarPorGenero")
    public String buscarPorGenero(@RequestParam(required = false) String nomeGenero, Model model) {
        // Consulta 1 usando JPQL
        Genero genero = repository.findByNomeGenero(nomeGenero);
        model.addAttribute("genero", genero);

        return "/generos/buscarPorGenero";
    }

}
