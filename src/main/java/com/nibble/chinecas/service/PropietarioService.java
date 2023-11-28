package com.nibble.chinecas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Propietario;
import com.nibble.chinecas.repository.IPropietarioRepository;

@Service
public class PropietarioService implements IService<Propietario, String>{

    @Autowired
    private IPropietarioRepository data;

    @Override
    public List<Propietario> obtenerTodos() {
        return (List<Propietario>) data.findAll();
    }

    @Override
    public Optional<Propietario> obtener(String id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Propietario t) {
        int res=0;
        Propietario propietario=data.save(t);
        if(!propietario.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(String id) {
        data.deleteById(id);
    }
    
    // Custom methods
    public List<Propietario> obtenerPorCorreo(String correo) {
        List<Propietario> propietarios = new ArrayList<>();
        for (Propietario propietario : obtenerTodos()) {
            if (propietario.getCorreo().equals(correo)) {
                propietarios.add(propietario);
            }
        }
        return propietarios;
    }
}
