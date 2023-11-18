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

import com.nibble.chinecas.model.Agricultor;
import com.nibble.chinecas.model.Propietario;
import com.nibble.chinecas.service.AgricultorService;
import com.nibble.chinecas.service.PropietarioService;

@Controller
@RequestMapping("/agricultor")
public class AgricultorController {
    
    @Autowired
    private AgricultorService agricultorService;

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping
    public String listar(Model model){
        List<Agricultor> agricultores = agricultorService.obtenerTodos();
        model.addAttribute("agricultores", agricultores); // Ojito con esto
        return "agricultor/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("agricultor", new Agricultor());
        model.addAttribute("propietario", new Propietario());
        return "agricultor/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Agricultor agricultor, Propietario propietario){
        agricultorService.guardar(agricultor);
        return "redirect:/agricultor";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model){
        Optional<Agricultor> agricultor = agricultorService.obtener(id);
        Optional<Propietario> propietario = propietarioService.obtener(id);
        model.addAttribute("agricultor", agricultor);
        model.addAttribute("propietario", propietario);
        return "agricultor/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id){
        agricultorService.eliminar(id);
        propietarioService.eliminar(id);
        return "redirect:/agricultor";
    }
}
