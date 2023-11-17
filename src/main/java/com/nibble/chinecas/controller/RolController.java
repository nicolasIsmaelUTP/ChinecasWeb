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

import com.nibble.chinecas.model.Opcion;
import com.nibble.chinecas.model.Rol;
import com.nibble.chinecas.service.RolService;

@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService service;

    @GetMapping
    public String listar(Model model) {
        List<Rol> roles = service.obtenerTodos();
        model.addAttribute("roles", roles);
        return "seguridad/rol/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "seguridad/rol/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Rol rol) {
        service.guardar(rol);
        return "redirect:/rol";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Rol rol = service.obtener(id).get();
        model.addAttribute("rol", rol);
        return "seguridad/rol/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id) {
        service.eliminar(id);
        return "redirect:/rol";
    }

    @GetMapping("/permisos/{id}")
    public String permisos(@PathVariable("id") int id, Model model) {
        Rol rol = service.obtener(id).get();
        List<Opcion> opciones = rol.getOpciones();
        model.addAttribute("rol", rol);
        model.addAttribute("opciones", opciones);
        return "seguridad/rol/permisos";
    }
}
