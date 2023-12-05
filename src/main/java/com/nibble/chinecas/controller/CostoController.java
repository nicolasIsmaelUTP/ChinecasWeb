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

import com.nibble.chinecas.model.Costo;
import com.nibble.chinecas.service.CostoService;

@Controller
@RequestMapping("/costo")
public class CostoController {
    
    @Autowired
    private CostoService costoService;

    @GetMapping
    public String listar(Model model){
        List<Costo> costos = costoService.obtenerTodos();
        model.addAttribute("costos", costos);
        return "costo/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("costo", new Costo());
        model.addAttribute("readonly", false);
        return "costo/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Costo costo){
        costoService.guardar(costo);
        return "redirect:/costo";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Optional<Costo> costo = costoService.obtener(id);
        model.addAttribute("costo", costo);
        model.addAttribute("readonly", true);
        return "costo/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id, Model model){
        costoService.eliminar(id);
        return "redirect:/costo";
    }
}
