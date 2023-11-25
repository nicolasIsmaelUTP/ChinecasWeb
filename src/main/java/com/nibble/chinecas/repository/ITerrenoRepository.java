package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Terreno;

@Repository
public interface ITerrenoRepository extends CrudRepository<Terreno, Integer>{
    
}
