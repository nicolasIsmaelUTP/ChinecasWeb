package com.nibble.chinecas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "unidad_operadora")
public class UnidadOperadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    public UnidadOperadora() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
