package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.TipoEmpresa;

@Repository
public interface ITipoEmpresaRepository extends CrudRepository<TipoEmpresa, Integer>{
    
}
