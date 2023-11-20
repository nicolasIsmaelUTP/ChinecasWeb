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
import com.nibble.chinecas.service.AgricultorService;
import com.nibble.chinecas.service.PropietarioService;
import com.nibble.chinecas.service.TipoDocumentoService;

@Controller
@RequestMapping("/agricultor")
public class AgricultorController {
    
    @Autowired
    private AgricultorService agricultorService;

    @Autowired
    private PropietarioService propietarioService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public String listar(Model model){
        List<Agricultor> agricultores = agricultorService.obtenerTodos();
        model.addAttribute("agricultores", agricultores);
        return "agricultor/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("agricultor", new Agricultor());
        model.addAttribute("tiposDocumento", tipoDocumentoService.obtenerTodos());
        model.addAttribute("readonly", false);
        return "agricultor/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Agricultor agricultor){

        agricultor.getPropietario().setId(agricultor.getNumDoc());
        agricultor.getPropietario().setTipo("natural");

        propietarioService.guardar(agricultor.getPropietario());
        agricultorService.guardar(agricultor);
        return "redirect:/agricultor";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model){
        Optional<Agricultor> agricultor = agricultorService.obtener(id);
        model.addAttribute("agricultor", agricultor);
        model.addAttribute("tiposDocumento", tipoDocumentoService.obtenerTodos());
        model.addAttribute("readonly", true);
        return "agricultor/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id){
        agricultorService.eliminar(id);
        propietarioService.eliminar(id);
        return "redirect:/agricultor";
    }
}
