package com.nibble.chinecas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nibble.chinecas.model.Usuario;

@Controller
@RequestMapping("")
public class LoginController {

    // Método para manejar la solicitud GET en la ruta raíz
    @GetMapping
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/core/login";
    }

}

