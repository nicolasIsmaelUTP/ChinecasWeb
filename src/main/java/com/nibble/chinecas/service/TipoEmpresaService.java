package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.TipoEmpresa;
import com.nibble.chinecas.repository.ITipoEmpresaRepository;

@Service
public class TipoEmpresaService implements IService<TipoEmpresa, Integer> {

    @Autowired
    private ITipoEmpresaRepository data;

    @Override
    public List<TipoEmpresa> obtenerTodos() {
        return (List<TipoEmpresa>) data.findAll();
    }

    @Override
    public Optional<TipoEmpresa> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(TipoEmpresa t) {
        int res = 0;
        TipoEmpresa tipoEmpresa = data.save(t);
        if (!tipoEmpresa.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
}
