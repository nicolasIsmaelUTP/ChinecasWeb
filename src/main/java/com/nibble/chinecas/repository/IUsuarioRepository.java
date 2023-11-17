package com.nibble.chinecas.repository;

import com.nibble.chinecas.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, String> {
    
}
