package com.nibble.chinecas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departamento", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Min(1)
    private int id;
    
    @Column(nullable = false, length = 20)
    @Size(min = 3, max = 20)
    private String nombre;

    public Departamento() {
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

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
}
