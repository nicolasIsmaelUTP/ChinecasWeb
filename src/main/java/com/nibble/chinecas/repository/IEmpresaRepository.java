package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Empresa;

@Repository
public interface IEmpresaRepository extends CrudRepository<Empresa, String>{
    
}
