package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Empresa;
import com.nibble.chinecas.repository.IEmpresaRepository;

@Service
public class EmpresaService implements IService<Empresa, String>{

    @Autowired
    private IEmpresaRepository data;

    @Override
    public List<Empresa> obtenerTodos() {
        return (List<Empresa>) data.findAll();
    }

    @Override
    public Optional<Empresa> obtener(String id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Empresa t) {
        int res=0;
        Empresa empresa=data.save(t);
        if(!empresa.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(String id) {
        data.deleteById(id);
    }
    
}
