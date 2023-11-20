package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.TipoDocumento;

@Repository
public interface ITipoDocumento extends CrudRepository<TipoDocumento, Integer>{
    
}
