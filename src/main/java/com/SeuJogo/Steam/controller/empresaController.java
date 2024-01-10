package com.SeuJogo.Steam.controller;


import com.SeuJogo.Steam.model.jogo.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresa")
public class empresaController {
    @Autowired
    private EmpresaRepository repository;
    @Autowired
    private JogoRepository repositoryJogo;

    @GetMapping("/dadosEmpresa")
    public String carregaPaginaEmpresa(Long idempresa, Model model){
        if(idempresa != null)
        {
            Empresa e1 = repository.getReferenceById(idempresa);
            model.addAttribute("empresa",e1);
        }
        //model.addAttribute("listaJogo", repositoryJogo.findAll());
        return "/empresa/dadosEmpresa";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repository.findAll());
        return "/empresa/listagem";
    }

    @PostMapping
    public String cadastraEmpresa(DadosCadastraEmpresa d){
        Empresa e1 = new Empresa(d);
        repository.save(e1);
        return "redirect:/empresa/dadosEmpresa";
    }

    @DeleteMapping
    @Transactional
    public String removeEmpresa(Long idempresa){
        repository.deleteById(idempresa);
        return "redirect:/empresa/listagem";
    }

    @PutMapping
    @Transactional
    public String alteraEmpresa(DadosAlteraEmpresa d){
        Empresa e1 = repository.getReferenceById(d.idempresa());
        e1.atualizaDados(d);
        return "empresa/dadosEmpresa";
    }

    //2 consultas usando Derived Query
    @GetMapping("/buscarPorNome")
    public String buscarPorNome(@RequestParam(required = false) String nomeEmpresa, Model model) {
        if (nomeEmpresa != null) {
            List<Empresa> empresas = repository.findByNomeEmpresa(nomeEmpresa);
            model.addAttribute("empresas", empresas);
        }
        return "/empresa/buscarPorNome";
    }
}
