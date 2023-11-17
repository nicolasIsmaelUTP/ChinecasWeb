package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Rol;
import com.nibble.chinecas.repository.IRolRepository;

@Service
public class RolService implements IService<Rol, Integer> {

    @Autowired
    private IRolRepository data;

    @Override
    public List<Rol> obtenerTodos() {
        return (List<Rol>) data.findAll();
    }

    @Override
    public Optional<Rol> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Rol t) {
        int res=0;
        Rol rol=data.save(t);
        if(!rol.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
}
