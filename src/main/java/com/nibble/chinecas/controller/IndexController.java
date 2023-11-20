package com.nibble.chinecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nibble.chinecas.model.Usuario;
import com.nibble.chinecas.service.UsuarioService;

@Controller
@RequestMapping("/index")
public class IndexController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String autenticar(Usuario usuario, Model model){
        // Autenticar al usuario utilizando el servicio de usuario
        Usuario usuarioAutenticado = usuarioService.autenticar(usuario);
        if(usuarioAutenticado != null){
            // Si el usuario es autenticado, agregarlo al modelo y redirigir a la página de inicio
            model.addAttribute("usuario", usuarioAutenticado);
            return "/core/index";
        }
        // Si la autenticación falla, agregar un mensaje de error al modelo y redirigir a la página de inicio de sesión
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "core/login";
    }
}
