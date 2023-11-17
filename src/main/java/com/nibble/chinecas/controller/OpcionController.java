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
import com.nibble.chinecas.service.OpcionService;

@Controller
@RequestMapping("/opcion")
public class OpcionController {
    
    @Autowired
    private OpcionService opcionService;

    @GetMapping
    public String listar(Model model){
        List<Opcion> opciones = opcionService.obtenerTodos();
        model.addAttribute("opciones", opciones);
        return "seguridad/opcion/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("opcion", new Opcion());
        return "seguridad/opcion/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Opcion opcion){
        opcionService.guardar(opcion);
        return "redirect:/opcion";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Optional<Opcion> opcion = opcionService.obtener(id);
        model.addAttribute("opcion", opcion);
        return "seguridad/opcion/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id){
        opcionService.eliminar(id);
        return "redirect:/opcion";
    }

}
