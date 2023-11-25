package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Departamento;

@Repository
public interface IDepartamentoRepository extends CrudRepository<Departamento, Integer>{
    
}
