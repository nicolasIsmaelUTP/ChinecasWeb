package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Opcion;

@Repository
public interface IOpcionRepository extends CrudRepository<Opcion, Integer>{
    
}
