package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Costo;

@Repository
public interface ICostoRepository extends CrudRepository<Costo, Integer>{
    
}
