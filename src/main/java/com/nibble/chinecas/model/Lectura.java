package com.nibble.chinecas.model;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="lectura")
public class Lectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Min(1)
    private int id;

    @Column(nullable = false)
    private double volumen_utilizado;

    @ManyToOne
    @JoinColumn(name = "costos_id", nullable = false)
    private Costo costo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "terreno_codigo", nullable = false)
    private Terreno terreno;

    public Lectura() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVolumen_utilizado() {
        return volumen_utilizado;
    }

    public void setVolumen_utilizado(double volumen_utilizado) {
        this.volumen_utilizado = volumen_utilizado;
    }

    public Costo getCosto() {
        return costo;
    }

    public void setCosto(Costo costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

}
