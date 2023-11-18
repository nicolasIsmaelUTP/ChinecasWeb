package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Propietario;

@Repository
public interface IPropietarioRepository extends CrudRepository<Propietario, String>{
    
}
