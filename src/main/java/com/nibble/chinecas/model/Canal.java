package com.nibble.chinecas.model;

import jakarta.persistence.*;

@Entity
@Table(name="canal")
public class Canal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Distrito distrito;
    private UnidadOperadora UnidadOperadora;

    public Canal() {
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

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public UnidadOperadora getUnidadOperadora() {
        return UnidadOperadora;
    }

    public void setUnidadOperadora(UnidadOperadora UnidadOperadora) {
        this.UnidadOperadora = UnidadOperadora;
    }

    
}
