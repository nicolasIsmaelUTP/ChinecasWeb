package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Terreno;
import com.nibble.chinecas.repository.ITerrenoRepository;

@Service
public class TerrenoService implements IService<Terreno, Integer>{

    @Autowired
    private ITerrenoRepository data;

    @Override
    public List<Terreno> obtenerTodos() {
        return (List<Terreno>) data.findAll();
    }

    @Override
    public Optional<Terreno> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Terreno t) {
        int res=0;
        Terreno terreno=data.save(t);
        if(!terreno.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
}
