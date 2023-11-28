package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Lectura;
import com.nibble.chinecas.repository.ILecturaRepository;

@Service
public class LecturaService implements IService<Lectura, Integer>{

    @Autowired
    private ILecturaRepository data;

    @Override
    public List<Lectura> obtenerTodos() {
        return (List<Lectura>) data.findAll();
    }

    @Override
    public Optional<Lectura> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Lectura t) {
        int res=0;
        Lectura lectura=data.save(t);
        if(!lectura.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
}
