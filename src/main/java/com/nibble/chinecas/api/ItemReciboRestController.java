package com.nibble.chinecas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.nibble.chinecas.service.LecturaService;


@RestController
@RequestMapping("/api/items")
public class ItemReciboRestController {
    @Autowired
    private LecturaService lecturaService;

    @GetMapping
    public List<ItemRecibo> obtenerTodos() {
        return lecturaService.obtenerItems(1, 2023);
    }
}
