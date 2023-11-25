package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Recibo;

@Repository
public interface IReciboRepository extends CrudRepository<Recibo, Integer>{
    
}
