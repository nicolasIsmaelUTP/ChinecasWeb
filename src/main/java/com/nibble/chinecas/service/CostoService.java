package com.nibble.chinecas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.model.Costo;
import com.nibble.chinecas.model.Lectura;
import com.nibble.chinecas.model.Terreno;
import com.nibble.chinecas.repository.ICostoRepository;

@Service
public class CostoService implements IService<Costo, Integer> {

    @Autowired
    private ICostoRepository data;

    @Override
    public List<Costo> obtenerTodos() {
        return (List<Costo>) data.findAll();
    }

    @Override
    public Optional<Costo> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(Costo t) {
        int res=0;
        Costo costo=data.save(t);
        if(!costo.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }
    
    /**
     * Obtiene la lista de costos disponibles para un terreno en un año específico.
     * 
     * @param terreno El terreno para el cual se obtendrán los costos disponibles.
     * @param anio El año para el cual se obtendrán los costos disponibles.
     * @return La lista de costos disponibles para el terreno en el año especificado.
     */
    public List<Costo> obtenerCostosDisponiblesParaTerrenoEnAnio(Terreno terreno, int anio) {
        // Todos los costos
        List<Costo> costos = obtenerTodos();

        // Costos de lecturas ya realizadas
        List<Costo> costosDeLecturas = new LecturaService().obtenerLecturasPorTerrenoYAnio(terreno, anio)
            .stream()
            .map(Lectura::getCosto)
            .collect(Collectors.toList());

        // Costos disponibles
        return costos.stream()
            .filter(costo -> !costosDeLecturas.contains(costo))
            .collect(Collectors.toList());
    }
}
