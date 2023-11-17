package com.nibble.chinecas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tipo_documento",
       uniqueConstraints = {
           @UniqueConstraint(name = "uk_nombre", columnNames = "nombre")
       })
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Min(value = 1, message = "El id debe ser mayor que 0")
    private int id;

    @Column(name = "nombre", nullable = false)
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑüÜ\\s]+$", message = "El nombre solo puede contener letras")
    private String nombre;

    // Getters and Setters
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