package com.nibble.chinecas.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibble.chinecas.service.TipoEmpresaService;

@RestController
@RequestMapping("/api/conteoTipoEmpresa")
public class ConteoTipoEmpresaRestController {
    @Autowired
    private TipoEmpresaService service;

    @GetMapping
    public List<ConteoTipoEmpresa> obtenerTodos() {
        return service.cantidadEmpresasPorTipoEmpresa();
    }
}
