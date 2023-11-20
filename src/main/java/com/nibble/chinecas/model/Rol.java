package com.nibble.chinecas.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    // Relationships

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Opcion> opciones;

    // Getters and setters

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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    // Methods

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Verifica si la opción dada está disponible para este rol.
     * 
     * @param opcion la opción a verificar
     * @return true si el rol tiene la opción dada, false en caso contrario
     */
    public boolean tieneOpcion(String opcion) {
        for (Opcion o : opciones) {
            if (o.getDocumento().equals(opcion)) {
                return true;
            }
        }
        return false;
    }
}