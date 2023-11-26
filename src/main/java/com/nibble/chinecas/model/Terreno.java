package com.nibble.chinecas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="terreno")
public class Terreno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @Min(1)
    private int codigo;

    @Column(nullable = false)
    private double ha_total;

    @Column(nullable = false)
    private double ha_bajo_riego;

    @Column(nullable = false)
    private double volumen_agua_otorgado;

    @Column(nullable = false, length = 100)
    @Size(min = 10, max = 100)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    @Size(min = 5, max = 11)
    @Pattern(regexp = "^[0-9]*$")
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "canal_id", nullable = false)
    private Canal canal;

    public Terreno() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getHa_total() {
        return ha_total;
    }

    public void setHa_total(double ha_total) {
        this.ha_total = ha_total;
    }

    public double getHa_bajo_riego() {
        return ha_bajo_riego;
    }

    public void setHa_bajo_riego(double ha_bajo_riego) {
        this.ha_bajo_riego = ha_bajo_riego;
    }

    public double getVolumen_agua_otorgado() {
        return volumen_agua_otorgado;
    }

    public void setVolumen_agua_otorgado(double volumen_agua_otorgado) {
        this.volumen_agua_otorgado = volumen_agua_otorgado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
    
}
