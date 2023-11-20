package com.nibble.chinecas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empresa",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_propietario_id", columnNames = "propietario_id")
    })
public class Empresa {
    @Id
    @Column(name = "ruc", length = 11, nullable = false)
    @Pattern(regexp = "\\d+", message = "El RUC debe contener solo números")
    private String ruc;
    
    @Column(name = "nombre", length = 50, nullable = false)
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 20 caracteres")
    private String nombre;
    
    @Column(name = "razon_social", length = 100, nullable = false)
    @Size(min = 2, max = 100, message = "La razón social debe tener entre 2 y 30 caracteres")
    private String razonSocial;
    
    // Relationships

    @JoinColumn(name = "tipo_empresa_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoEmpresa tipoDeEmpresa;

    @JoinColumn(name = "propietario_id", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Propietario propietario;

    // Getters and Setters
    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public TipoEmpresa getTipoDeEmpresa() {
        return tipoDeEmpresa;
    }

    public void setTipoDeEmpresa(TipoEmpresa tipoDeEmpresa) {
        this.tipoDeEmpresa = tipoDeEmpresa;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}