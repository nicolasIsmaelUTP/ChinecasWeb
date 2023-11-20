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

import com.nibble.chinecas.model.Empresa;
import com.nibble.chinecas.model.TipoEmpresa;
import com.nibble.chinecas.service.EmpresaService;
import com.nibble.chinecas.service.PropietarioService;
import com.nibble.chinecas.service.TipoEmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private PropietarioService propietarioService;

    @Autowired
    private TipoEmpresaService tipoEmpresaService;

    @GetMapping
    public String listar(Model model) {
        List<Empresa> empresas = empresaService.obtenerTodos();
        model.addAttribute("empresas", empresas);
        return "empresa/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empresa", new Empresa());
        model.addAttribute("tiposDocumento", tipoEmpresaService.obtenerTodos());
        model.addAttribute("readonly", false);
        return "empresa/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Empresa empresa) {
        empresa.getPropietario().setId(empresa.getRuc());
        empresa.getPropietario().setTipo("juridica");

        propietarioService.guardar(empresa.getPropietario());
        empresaService.guardar(empresa);
        return "redirect:/empresa";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model) {
        Optional<Empresa> empresa = empresaService.obtener(id);
        model.addAttribute("empresa", empresa);
        model.addAttribute("tiposDocumento", tipoEmpresaService.obtenerTodos());
        model.addAttribute("readonly", true);
        return "empresa/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") String id) {
        empresaService.eliminar(id);
        propietarioService.eliminar(id);
        return "redirect:/empresa";
    }
}
