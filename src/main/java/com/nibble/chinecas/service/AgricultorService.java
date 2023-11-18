package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Agricultor;
import com.nibble.chinecas.repository.IAgricutorRepository;

@Service
public class AgricultorService implements IService<Agricultor, String>{

    @Autowired
    private IAgricutorRepository data;

    @Override
    public List<Agricultor> obtenerTodos() {
        return (List<Agricultor>) data.findAll();
    }

    @Override
    public Optional<Agricultor> obtener(String id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Agricultor t) {
        int res=0;
        Agricultor agricultor=data.save(t);
        if(!agricultor.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(String id) {
        data.deleteById(id);
    }
    
}
