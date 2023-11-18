package com.nibble.chinecas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "agricultor",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_propietario_id", columnNames = "propietario_id")
    })
public class Agricultor{
    @Id
    @Size(min = 8, max = 8)
    @Pattern(regexp = "\\d+")
    @Column(name = "num_doc")
    private String numDoc;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+")
    @Column(name = "primer_nombre")
    private String primerNombre;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+")
    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-záéíóúÁÉÍÓÚñÑüÜ]+")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    // Relationships

    @JoinColumn(name = "tipo_documento_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    @JoinColumn(name = "propietario_id", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Propietario propietario;

    // Getters and Setters

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
