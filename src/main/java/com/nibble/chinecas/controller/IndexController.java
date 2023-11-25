package com.nibble.chinecas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nibble.chinecas.model.Usuario;
import com.nibble.chinecas.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String index(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        return usuario != null ? "/core/tabla" : "core/login";
    }

    @PostMapping
    public String autenticar(Usuario usuario, Model model, HttpSession session){
        // Autenticar al usuario utilizando el servicio de usuario
        Usuario usuarioAutenticado = usuarioService.autenticar(usuario);
        if(usuarioAutenticado != null){
            // Si el usuario es autenticado, agregarlo al modelo y redirigir a la página de inicio
            model.addAttribute("usuario", usuarioAutenticado);
            session.setAttribute("usuario", usuarioAutenticado);
            return "/core/tabla";
        }
        // Si la autenticación falla, agregar un mensaje de error al modelo y redirigir a la página de inicio de sesión
        model.addAttribute("error", "Usuario o contraseña incorrectos");
        return "core/login";
    }
}
