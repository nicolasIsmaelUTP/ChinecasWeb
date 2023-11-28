package com.nibble.chinecas.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibble.chinecas.model.Agricultor;
import com.nibble.chinecas.model.Empresa;
import com.nibble.chinecas.model.Propietario;
import com.nibble.chinecas.service.AgricultorService;
import com.nibble.chinecas.service.EmpresaService;
import com.nibble.chinecas.service.PropietarioService;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioRestController {

    @Autowired
    private PropietarioService propietarioService;

    @Autowired
    private AgricultorService agricultorService;

    @Autowired
    private EmpresaService empresaService;

    /**
     * Obtiene todos los propietarios.
     * 
     * @return ArrayList con los propietarios y sus detalles.
     */
    @GetMapping
    public ArrayList<Object> obtenerTodos() {
        ArrayList<Object> propietarios = new ArrayList<Object>();
        List<Propietario> propietarioList = propietarioService.obtenerTodos();
        for (Propietario propietario : propietarioList) {
            Map<String, Object> propietarioMap = new TreeMap<>();
            propietarioMap.put("tipo", propietario.getTipo());
            propietarioMap.put("direccion", propietario.getDireccion());
            propietarioMap.put("correo", propietario.getCorreo());
            propietarioMap.put("telefono", propietario.getTelefono());

            // Si el propietario es de tipo "natural"
            if (propietario.getTipo().equals("natural")) {
                Agricultor agricultor = agricultorService.obtener(propietario.getId()).orElse(null);
                if (agricultor != null) {
                    propietarioMap.put("numDoc", agricultor.getNumDoc());
                    propietarioMap.put("primerNombre", agricultor.getPrimerNombre());
                    propietarioMap.put("segundoNombre", agricultor.getSegundoNombre());
                    propietarioMap.put("apellidoPaterno", agricultor.getApellidoPaterno());
                    propietarioMap.put("apellidoMaterno", agricultor.getApellidoMaterno());
                    propietarioMap.put("tipoDocumento", agricultor.getTipoDocumento().getNombre());
                }
            }
            // Si el propietario es de tipo "empresa"
            else {
                Empresa empresa = empresaService.obtener(propietario.getId()).orElse(null);
                if (empresa != null) {
                    propietarioMap.put("ruc", empresa.getRuc());
                    propietarioMap.put("nombre", empresa.getNombre());
                    propietarioMap.put("razonSocial", empresa.getRazonSocial());
                    propietarioMap.put("tipoDeEmpresa", empresa.getTipoDeEmpresa().getNombre());
                }
            }

            propietarios.add(propietarioMap);
        }

        return propietarios;
    }

    /**
     * Obtiene todos los agricultores.
     * 
     * @return ArrayList con los agricultores y sus detalles.
     */
    @GetMapping("/agricultores")
    public ArrayList<Object> obtenerAgricultores() {
        ArrayList<Object> agricultores = new ArrayList<Object>();
        List<Agricultor> agricultorList = agricultorService.obtenerTodos();
        for (Agricultor agricultor : agricultorList) {
            Map<String, Object> agricultorMap = new TreeMap<>();
            agricultorMap.put("numDoc", agricultor.getNumDoc());
            agricultorMap.put("primerNombre", agricultor.getPrimerNombre());
            agricultorMap.put("segundoNombre", agricultor.getSegundoNombre());
            agricultorMap.put("apellidoPaterno", agricultor.getApellidoPaterno());
            agricultorMap.put("apellidoMaterno", agricultor.getApellidoMaterno());
            agricultorMap.put("tipoDocumento", agricultor.getTipoDocumento().getNombre());
            agricultorMap.put("direccion", agricultor.getPropietario().getDireccion());
            agricultorMap.put("correo", agricultor.getPropietario().getCorreo());
            agricultorMap.put("telefono", agricultor.getPropietario().getTelefono());
            agricultores.add(agricultorMap);
        }

        return agricultores;
    }

    /**
     * Obtiene todas las empresas.
     * 
     * @return ArrayList con las empresas y sus detalles.
     */
    @GetMapping("/empresas")
    public ArrayList<Object> obtenerEmpresas() {
        ArrayList<Object> empresas = new ArrayList<Object>();
        List<Empresa> empresaList = empresaService.obtenerTodos();
        for (Empresa empresa : empresaList) {
            Map<String, Object> empresaMap = new TreeMap<>();
            empresaMap.put("ruc", empresa.getRuc());
            empresaMap.put("nombre", empresa.getNombre());
            empresaMap.put("razonSocial", empresa.getRazonSocial());
            empresaMap.put("tipoDeEmpresa", empresa.getTipoDeEmpresa().getNombre());
            empresaMap.put("direccion", empresa.getPropietario().getDireccion());
            empresaMap.put("correo", empresa.getPropietario().getCorreo());
            empresaMap.put("telefono", empresa.getPropietario().getTelefono());
            empresas.add(empresaMap);
        }

        return empresas;
    }

}
