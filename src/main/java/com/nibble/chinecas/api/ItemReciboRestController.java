package com.nibble.chinecas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nibble.chinecas.service.LecturaService;


@RestController
@RequestMapping("/api/items")
public class ItemReciboRestController {
    @Autowired
    private LecturaService lecturaService;

    @GetMapping("{terreno_codigo}/{anio}")
    public List<ItemRecibo> obtenerTodos(@PathVariable("terreno_codigo") int terreno_codigo, @PathVariable("anio") int anio) {
        return lecturaService.obtenerItems(terreno_codigo, anio);
    }
}
