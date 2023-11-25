package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Distrito;

@Repository
public interface IDistritoRepository extends CrudRepository<Distrito, Integer>{
    
}
