package com.nibble.chinecas.controller;

import java.time.Year;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nibble.chinecas.model.*;
import com.nibble.chinecas.service.*;



@Controller
@RequestMapping("/terreno")
public class TerrenoController {

    @Autowired
    private TerrenoService terrenoService;

    @Autowired
    private PropietarioService propietarioService;

    @Autowired
    private CanalService canalService;

    @Autowired
    private CostoService costoService;

    @GetMapping
    public String listar(Model model){
        List<Terreno> terrenos = terrenoService.obtenerTodos();
        model.addAttribute("terrenos", terrenos);
        return "terreno/listar";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("terreno", new Terreno());
        model.addAttribute("propietarios", propietarioService.obtenerTodos());
        model.addAttribute("canales", canalService.obtenerTodos());
        model.addAttribute("readonly", false);
        return "terreno/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Terreno terreno){
        terrenoService.guardar(terreno);
        return "redirect:/terreno";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Optional<Terreno> terreno = terrenoService.obtener(id);
        model.addAttribute("terreno", terreno);
        model.addAttribute("propietarios", propietarioService.obtenerTodos());
        model.addAttribute("canales", canalService.obtenerTodos());
        model.addAttribute("readonly", true);
        return "terreno/formulario";
    }

    @GetMapping("/realizarLectura/{id}")
    public String realizarLectura(@PathVariable("id") int id, Model model){
        Optional<Terreno> terrenoOptional = terrenoService.obtener(id);
        if (terrenoOptional.isPresent()) {
            Terreno terreno = terrenoOptional.get();
            model.addAttribute("lectura", new Lectura());
            model.addAttribute("terreno", terreno);

            int currentYear = Year.now().getValue();
            List<Costo> costos = costoService.obtenerCostosDisponiblesParaTerrenoEnAnio(terreno, currentYear);

            model.addAttribute("costos", costos);
            return "terreno/lectura";
        }
        return "redirect:/terreno";
    }
    
}
