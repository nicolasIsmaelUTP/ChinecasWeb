package com.nibble.chinecas.model;

public class Distrito {
    private int id;
    private String nombre;
    private Provincia provincia;

    public Distrito() {
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia Provincia) {
        this.provincia = Provincia;
    }
}
