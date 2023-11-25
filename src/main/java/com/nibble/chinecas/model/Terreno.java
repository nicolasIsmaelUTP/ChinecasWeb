package com.nibble.chinecas.model;

import jakarta.persistence.*;

@Entity
@Table(name="terreno")
public class Terreno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private double ha_total;
    private double ha_bajo_riego;
    private double volumen_agua_otorgado;
    private String direccion;
    private Propietario propietario;
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
