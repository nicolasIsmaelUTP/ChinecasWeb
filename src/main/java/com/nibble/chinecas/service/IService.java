package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;

public interface IService<T, K> {

    public List<T> obtenerTodos();

    public Optional<T> obtener(K id);

    public int guardar(T t);

    public void eliminar(K id);

}
