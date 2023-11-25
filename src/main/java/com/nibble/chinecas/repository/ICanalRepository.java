package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Canal;

@Repository
public interface ICanalRepository extends CrudRepository<Canal, Integer>{
    
}
