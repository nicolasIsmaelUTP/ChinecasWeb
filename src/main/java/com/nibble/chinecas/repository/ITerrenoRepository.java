package com.nibble.chinecas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Terreno;

@Repository
public interface ITerrenoRepository extends CrudRepository<Terreno, Integer>{
    

    @Query("SELECT t FROM Terreno t WHERE t.canal.distrito.id = :distritoId")
    List<Terreno> findByDistrito(@Param("distritoId") int distritoId);

}
