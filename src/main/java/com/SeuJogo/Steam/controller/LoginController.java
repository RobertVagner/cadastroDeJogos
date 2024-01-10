package com.SeuJogo.Steam.controller;

import com.SeuJogo.Steam.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public String showLoginForm() {
        return "login/login";
    }

    @PostMapping
    public String processLogin(@RequestParam String username, @RequestParam String senha, RedirectAttributes attributes) {
        if (authenticationService.authenticate(username, senha)) {
            return "redirect:/menus/principal";
        } else {
            attributes.addFlashAttribute("error", "Credenciais inválidas");
            return "redirect:/login";
        }
    }

}