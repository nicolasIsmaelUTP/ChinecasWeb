package com.nibble.chinecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nibble.chinecas.model.Costo;
import com.nibble.chinecas.service.CostoService;

@Controller
@RequestMapping("/tarifa")
public class TarifaController {

    @Autowired
    private CostoService costoService;

    @GetMapping
    public String listar(Model model){
        List<Costo> costos = costoService.obtenerTodos();
        model.addAttribute("costos", costos);
        return "tarifa/listar";
    }
}
