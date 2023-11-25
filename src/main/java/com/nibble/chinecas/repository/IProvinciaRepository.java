package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Provincia;

@Repository
public interface IProvinciaRepository extends CrudRepository<Provincia, Integer>{
    
}
