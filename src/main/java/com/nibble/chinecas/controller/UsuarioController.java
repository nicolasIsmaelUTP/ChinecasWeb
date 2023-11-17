package com.nibble.chinecas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nibble.chinecas.model.Usuario;
import com.nibble.chinecas.service.RolService;
import com.nibble.chinecas.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listar(Model model){
        List<Usuario> usuarios=usuarioService.obtenerTodos();
        model.addAttribute("usuarios", usuarios);
        return "seguridad/usuario/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("readonly", false);
        model.addAttribute("roles", rolService.obtenerTodos());
        return "seguridad/usuario/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario){
        usuarioService.guardar(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/editar/{username}")
    public String editar(@PathVariable("username") String username, Model model){
        Optional<Usuario> usuario = usuarioService.obtener(username);
        model.addAttribute("usuario", usuario);
        model.addAttribute("readonly", true);
        model.addAttribute("roles", rolService.obtenerTodos());
        return "seguridad/usuario/formulario";
    }

    @GetMapping("/eliminar/{username}")
    public String eliminar(@PathVariable("username") String username){
        usuarioService.eliminar(username);
        return "redirect:/usuario";
    }
}
