package com.nibble.chinecas.model;

import jakarta.persistence.*;

@Entity
@Table(name="costo")
public class Costo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private double valor_metro_cubico;

    public Costo(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor_metro_cubico() {
        return valor_metro_cubico;
    }

    public void setValor_metro_cubico(double valor_metro_cubico) {
        this.valor_metro_cubico = valor_metro_cubico;
    }

}
