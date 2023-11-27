package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nibble.chinecas.model.UnidadOperadora;
import com.nibble.chinecas.repository.IUnidadOperadoraRepository;

public class UnidadOperadoraService implements IService<UnidadOperadora, Integer>{

    @Autowired
    private IUnidadOperadoraRepository data;

    @Override
    public List<UnidadOperadora> obtenerTodos() {
        return (List<UnidadOperadora>) data.findAll();
    }

    @Override
    public Optional<UnidadOperadora> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(UnidadOperadora t) {
        int res=0;
        UnidadOperadora unidadOperadora=data.save(t);
        if(!unidadOperadora.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
}
