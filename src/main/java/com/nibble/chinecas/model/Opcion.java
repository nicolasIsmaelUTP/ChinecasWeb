package com.nibble.chinecas.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "opcion")
public class Opcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "documento", nullable = false, length = 50)
    private String documento;

    @Column(name = "estado", nullable = false, length = 1)
    private Character estado;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "grupo", nullable = false)
    private int grupo;

    // Relationships

    @JoinTable(name = "permiso", joinColumns = {
        @JoinColumn(name = "opcion_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "rol_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> roles;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String nombre) {
        this.documento = nombre;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcionRol) {
        this.descripcion = descripcionRol;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupoRol) {
        this.grupo = grupoRol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

}
