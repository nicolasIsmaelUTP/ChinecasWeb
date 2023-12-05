package com.nibble.chinecas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.api.ItemRecibo;
import com.nibble.chinecas.model.Lectura;
import com.nibble.chinecas.repository.ILecturaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class LecturaService implements IService<Lectura, Integer> {

    @Autowired
    private ILecturaRepository data;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Lectura> obtenerTodos() {
        return (List<Lectura>) data.findAll();
    }

    @Override
    public Optional<Lectura> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Lectura t) {
        int res = 0;
        Lectura lectura = data.save(t);
        if (!lectura.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }

    
    public List<ItemRecibo> obtenerItems(int terreno_codigo, int anio) {
        String sql = "SELECT c.descripcion, YEAR(l.fecha), c.valor_metro_cubico, l.volumen_utilizado FROM lectura l INNER JOIN costo c ON l.costos_id = c.id WHERE l.terreno_codigo = :terreno_codigo AND YEAR(l.fecha) = :anio";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("terreno_codigo", terreno_codigo);
        query.setParameter("anio", anio);
        List<?> items = query.getResultList();

        List<ItemRecibo> itemRecibos = new ArrayList<ItemRecibo>();
        for (Object item : items) {
            Object[] result = (Object[]) item;
            String descripcion = (String) result[0];
            int year = (int) result[1];
            double valor_metro_cubico = (double) result[2];
            double volumen_utilizado = (double) result[3];
            ItemRecibo itemRecibo = new ItemRecibo(descripcion, year, valor_metro_cubico, volumen_utilizado);
            itemRecibos.add(itemRecibo);
        }

        return itemRecibos;
    }
}
