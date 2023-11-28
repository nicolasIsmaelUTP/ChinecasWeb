package com.nibble.chinecas.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nibble.chinecas.model.*;
import com.nibble.chinecas.service.*;

@Controller
@RequestMapping("/lectura")
public class LecturaController {
    
    @Autowired
    private LecturaService lecturaService;

    @Autowired
    private CostoService costoService;

    @Autowired
    private TerrenoService terrenoService;

    @GetMapping
    public String listar(Model model){
        List<Lectura> lecturas = lecturaService.obtenerTodos();
        model.addAttribute("lecturas", lecturas);
        return "lectura/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("lectura", new Lectura());
        model.addAttribute("costos", costoService.obtenerTodos());
        model.addAttribute("terrenos", terrenoService.obtenerTodos());
        model.addAttribute("readonly", false);
        return "lectura/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Lectura lectura){
        Lectura l = lectura;
        l.setFecha(new Date()); //Para la fecha actual
        lecturaService.guardar(l);
        return "redirect:/lectura";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Optional<Lectura> lectura = lecturaService.obtener(id);
        model.addAttribute("lectura", lectura);
        model.addAttribute("costos", costoService.obtenerTodos());
        model.addAttribute("terrenos", terrenoService.obtenerTodos());
        model.addAttribute("readonly", true);
        return "lectura/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id){
        lecturaService.eliminar(id);
        return "redirect:/lectura";
    }
}
