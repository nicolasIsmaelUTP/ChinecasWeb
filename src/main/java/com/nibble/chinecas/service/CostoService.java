package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Costo;
import com.nibble.chinecas.repository.ICostoRepository;

@Service
public class CostoService implements IService<Costo, Integer> {

    @Autowired
    private ICostoRepository data;

    @Override
    public List<Costo> obtenerTodos() {
        return (List<Costo>) data.findAll();
    }

    @Override
    public Optional<Costo> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Costo t) {
        int res=0;
        Costo costo=data.save(t);
        if(!costo.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
}
