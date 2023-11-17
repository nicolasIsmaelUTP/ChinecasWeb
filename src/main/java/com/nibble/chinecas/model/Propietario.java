package com.nibble.chinecas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "propietario")
public class Propietario {
    @Id
    @Size(min = 8, max = 11, message = "El campo 'id' debe tener una longitud de 8 o 11 caracteres.")
    @Column(name = "id")
    private String id;

    @NotNull(message = "El campo 'tipo' es obligatorio.")
    @Pattern(regexp = "natural|juridica", message = "El campo 'tipo' solo puede tener los valores 'natural' o 'juridica'.")
    @Column(name = "tipo")
    private String tipo;

    @NotNull(message = "El campo 'direccion' es obligatorio.")
    @Size(min = 10, max = 100, message = "El campo 'direccion' debe tener una longitud entre 10 y 100 caracteres.")
    private String direccion;

    @NotNull(message = "El campo 'correo' es obligatorio.")
    @Size(min = 5, max = 50, message = "El campo 'correo' debe tener una longitud entre 5 y 50 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "El campo 'correo' debe ser una dirección de correo válida.")
    private String correo;

    @Size(min = 9, max = 9, message = "El campo 'telefono' debe tener una longitud de 9 caracteres.")
    @Pattern(regexp = "\\d+", message = "El campo 'telefono' solo puede contener dígitos.")
    private String telefono;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}