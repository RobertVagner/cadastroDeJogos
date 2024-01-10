package com.SeuJogo.Steam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menus")
public class menuController {
    @GetMapping("/principal")
    public String carregaMenus(){
        return "menus/principal";
    }
}
