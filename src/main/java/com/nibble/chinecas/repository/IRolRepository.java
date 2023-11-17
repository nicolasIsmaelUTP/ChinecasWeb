package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Rol;

@Repository
public interface IRolRepository extends CrudRepository<Rol, Integer>{
    
}
