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
    @NotNull
    @Size(min = 8, max = 8)
    @Column(name = "num_doc")
    private String numDoc;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    @Column(name = "primer_nombre")
    private String primerNombre;

    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Za-z]+")
    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "[A-Za-z]+")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    // Relationships

    @JoinColumn(name = "tipo_documento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;

    @JoinColumn(name = "propietario_id", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Propietario propietario;


    // Add getters and setters for the fields

    // Add any additional constraints as required

}
