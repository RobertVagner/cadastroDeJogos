package com.SeuJogo.Steam.controller;
import com.SeuJogo.Steam.model.jogo.*;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compra")
public class compraController {
    @Autowired
    private CompraRepository repositoryCompra;

    @Autowired
    private JogoRepository repositoryJogo;

    @Autowired
    private UsuarioRepository repositoryUsuario;
    @GetMapping("/dados")
    public String carregaPaginaCompra(Long idcompra, Model model){
        if(idcompra != null)
        {
            Compra j1 = repositoryCompra.getReferenceById(idcompra);
            model.addAttribute("compra",j1);
        }
        model.addAttribute("listaUsuario", repositoryUsuario.findAll());
        model.addAttribute("listaJogo", repositoryJogo.findAll());
        return "/compra/dados";}

    @GetMapping("/listagem")
    public String carregaListagem(Model model)
    {
        model.addAttribute("lista",repositoryCompra.findAll());
        return "/compra/listagem";
    }
    @PostMapping
    public String cadastraCompra(DadosCadastroCompra d){
        Compra j1 = new Compra(d);
        repositoryCompra.save(j1);
        return "redirect:/compra/dados";
    }

    @DeleteMapping
    @Transactional
    public String removeCompra(Long idcompra){
        repositoryCompra.deleteById(idcompra);
        return "redirect:/compra/listagem";
    }
}
