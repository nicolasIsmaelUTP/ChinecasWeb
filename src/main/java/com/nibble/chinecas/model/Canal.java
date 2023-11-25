package com.nibble.chinecas.model;

public class Canal {
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
