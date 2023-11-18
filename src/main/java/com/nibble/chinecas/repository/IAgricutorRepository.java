package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Agricultor;

@Repository
public interface IAgricutorRepository extends CrudRepository<Agricultor, String> {
    
}
