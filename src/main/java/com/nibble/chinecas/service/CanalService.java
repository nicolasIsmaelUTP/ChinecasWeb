package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.nibble.chinecas.model.Canal;
import com.nibble.chinecas.repository.ICanalRepository;

@Service
public class CanalService implements IService<Canal, Integer> {

    @Autowired
    private ICanalRepository data;

    @Override
    public List<Canal> obtenerTodos() {
        return (List<Canal>) data.findAll();
    }

    @Override
    public Optional<Canal> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Canal t) {
        int res=0;
        Canal canal=data.save(t);
        if(!canal.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
}
