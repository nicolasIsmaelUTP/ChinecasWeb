package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Lectura;

@Repository
public interface ILecturaRepository extends CrudRepository<Lectura, Integer>{
    
}
