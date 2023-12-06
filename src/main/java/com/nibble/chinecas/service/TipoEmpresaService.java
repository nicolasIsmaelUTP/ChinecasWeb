package com.nibble.chinecas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nibble.chinecas.api.ConteoTipoEmpresa;
import com.nibble.chinecas.model.TipoEmpresa;
import com.nibble.chinecas.repository.ITipoEmpresaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class TipoEmpresaService implements IService<TipoEmpresa, Integer> {

    @Autowired
    private ITipoEmpresaRepository data;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TipoEmpresa> obtenerTodos() {
        return (List<TipoEmpresa>) data.findAll();
    }

    @Override
    public Optional<TipoEmpresa> obtener(Integer id) {
        return data.findById(id);
    }

    @Override
    public int guardar(TipoEmpresa t) {
        int res = 0;
        TipoEmpresa tipoEmpresa = data.save(t);
        if (!tipoEmpresa.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void eliminar(Integer id) {
        data.deleteById(id);
    }

    public List<ConteoTipoEmpresa> cantidadEmpresasPorTipoEmpresa() {
        String sql="SELECT te.nombre AS nombre_tipo_empresa, te.descripcion AS descripcion_tipo_empresa, COUNT(e.ruc) AS cantidad_empresas FROM tipo_empresa te LEFT JOIN empresa e ON te.id = e.tipo_empresa_id GROUP BY te.nombre, te.descripcion";
        Query query = entityManager.createNativeQuery(sql);
        List<?> conteList = query.getResultList();
        List<ConteoTipoEmpresa> conteos =new ArrayList<>();
        for (Object o : conteList) {
            Object[] result = (Object[]) o;
            String nombre = result[0].toString();
            String descripcion = result[1].toString();
            int cantidad = Integer.parseInt(result[2].toString());
            ConteoTipoEmpresa conteo = new ConteoTipoEmpresa(nombre, descripcion, cantidad);
            conteos.add(conteo);
        }
        return conteos;
    }
}
