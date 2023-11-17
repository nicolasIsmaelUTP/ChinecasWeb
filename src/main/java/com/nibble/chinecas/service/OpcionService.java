package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Opcion;
import com.nibble.chinecas.repository.IOpcionRepository;

@Service
public class OpcionService implements IService<Opcion, Integer> {

    @Autowired
    private IOpcionRepository data;

    @Override
    public List<Opcion> obtenerTodos() {
        return (List<Opcion>) data.findAll();
    }

    @Override
    public Optional<Opcion> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Opcion t) {
        int res=0;
        Opcion opcion=data.save(t);
        if(!opcion.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
}
