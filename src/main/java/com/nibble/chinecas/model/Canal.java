package com.nibble.chinecas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="canal")
public class Canal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Min(1)
    private int id;

    @Column(nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "distrito_id", nullable = false)
    private Distrito distrito;

    @ManyToOne
    @JoinColumn(name = "unidad_operadora_id", nullable = false)
    private UnidadOperadora unidadOperadora;

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
        return unidadOperadora;
    }

    public void setUnidadOperadora(UnidadOperadora UnidadOperadora) {
        this.unidadOperadora = UnidadOperadora;
    }

    
}
