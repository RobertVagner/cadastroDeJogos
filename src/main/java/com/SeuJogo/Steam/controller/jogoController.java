package com.SeuJogo.Steam.controller;

import com.SeuJogo.Steam.model.jogo.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jogos")
public class jogoController {
    @Autowired
    private JogoRepository repository;
    @Autowired
    private GeneroRepository repositoryGenero;
    @Autowired
    private EmpresaRepository repositoryEmpresa;
    @GetMapping("/dados")
    public String carregaPaginaJogo(Long id, Model model){
        if(id != null)
        {
            Jogo j1 = repository.getReferenceById(id);
            model.addAttribute("jogo",j1);
        }
        model.addAttribute("listaGenero", repositoryGenero.findAll());
        model.addAttribute("listaEmpresa", repositoryEmpresa.findAll());
        return "/jogos/dados";}

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repository.findAll());
        return "/jogos/listagem";
    }
    @PostMapping
    public String cadastraJogo(DadosCadastroJogo d){
        Jogo j1 = new Jogo(d);
        repository.save(j1);
        return "redirect:/jogos/dados";
        //return "/jogos/dados";
    }

    @DeleteMapping
    @Transactional
    public String removeJogo(Long id){
        repository.deleteById(id);
        return "redirect:/jogos/listagem";
    }

    @PutMapping
    @Transactional
    public String alteraJogo(DadosAlteraJogo d){
        Jogo j1 = repository.getReferenceById(d.id());
        j1.atualizaDados(d);
        return "jogos/dados";
    }

    //implementar 1 consulta usando nativeQuery = true
    @GetMapping("/buscarPorNome")
    public String buscarPorUsername(@RequestParam(required = false) String nome, Model model) {
        Jogo jogo = repository.findByNomeNative(nome);
        model.addAttribute("jogos", jogo);
        return "/jogos/buscarPorNome";
    }

    //implementar 2 consultas usando JPQL
    @GetMapping("/buscarJogosMaisCaros")
    public String buscarJogosMaisCaros(@RequestParam(required = false) Double preco, Model model) {
        List<Jogo> jogosMaisCaros = repository.findByPrecoGreaterThan(preco);

        model.addAttribute("jogosMaisCaros", jogosMaisCaros);

        return "/jogos/buscarJogosMaisCaros";
    }
}
