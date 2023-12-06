package com.nibble.chinecas.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.api.ItemRecibo;
import com.nibble.chinecas.model.Lectura;
import com.nibble.chinecas.model.Terreno;
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

    /**
     * Obtiene una lista de lecturas filtradas por terreno y año.
     *
     * @param terreno el terreno por el cual filtrar las lecturas
     * @param anio el año por el cual filtrar las lecturas
     * @return una lista de lecturas filtradas por terreno y año
     */
    public List<Lectura> obtenerLecturasPorTerrenoYAnio(Terreno terreno, int anio) {
        List<Lectura> lecturas = (List<Lectura>) data.findAll();

        return lecturas.stream()
                .filter(lectura -> lectura.getTerreno().equals(terreno))
                .filter(lectura -> Calendar.getInstance().get(Calendar.YEAR) == anio)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene una lista de items de recibo para un terreno y año específico.
     * 
     * @param terreno_codigo El código del terreno.
     * @param anio           El año para el cual se desea obtener los items.
     * @return Una lista de objetos ItemRecibo que representan los items de recibo
     *         encontrados.
     */
    public List<ItemRecibo> obtenerItems(int terreno_codigo, int anio) {
        String sql = "SELECT c.descripcion, YEAR(l.fecha), c.valor_metro_cubico, l.volumen_utilizado, l.id FROM lectura l INNER JOIN costo c ON l.costos_id = c.id WHERE l.terreno_codigo = :terreno_codigo AND YEAR(l.fecha) = :anio";

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
            int lectura_id = (int) result[4];
            ItemRecibo itemRecibo = new ItemRecibo(descripcion, year, valor_metro_cubico, volumen_utilizado,
                    lectura_id);
            itemRecibos.add(itemRecibo);
        }

        return itemRecibos;
    }
}
