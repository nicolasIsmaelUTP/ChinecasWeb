package com.nibble.chinecas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="costo")
public class Costo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Min(1)
    private int id;

    @Column(nullable = false, length = 100)
    @Size(min = 10, max = 100)
    private String descripcion;

    @Column(nullable = false)
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
