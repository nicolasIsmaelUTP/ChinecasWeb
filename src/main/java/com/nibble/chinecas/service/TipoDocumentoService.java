package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.TipoDocumento;
import com.nibble.chinecas.repository.ITipoDocumento;

@Service
public class TipoDocumentoService implements IService<TipoDocumento, Integer> {

    @Autowired
    private ITipoDocumento data;

    @Override
    public List<TipoDocumento> obtenerTodos() {
        return (List<TipoDocumento>) data.findAll();
    }

    @Override
    public Optional<TipoDocumento> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(TipoDocumento t) {
        int res = 0;
        TipoDocumento tipoDocumento = data.save(t);
        if (!tipoDocumento.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }

}
