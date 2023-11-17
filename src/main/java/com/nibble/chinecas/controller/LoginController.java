package com.nibble.chinecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nibble.chinecas.model.Usuario;
import com.nibble.chinecas.service.UsuarioService;


@Controller
@RequestMapping("/")
public class LoginController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/core/login";
    }

    @PostMapping("/index")
    public String autenticar(Usuario usuario, Model model){
        Usuario usuarioAutenticado = usuarioService.autenticar(usuario);
        if(usuarioAutenticado != null){
            model.addAttribute("usuario", usuarioAutenticado);
            return "/core/index";
        }
        return "redirect:/";
    }

}
