package com.nibble.chinecas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nibble.chinecas.model.Item;

@Repository
public interface IItemRepository extends CrudRepository<Item, Integer>{
    
}
