package com.nibble.chinecas.model;

import java.sql.Date;

public class Recibo {
    private int numero;
    private Date fecha_emision;
    private Date fecha_vencimiento;
    private double interes_moratorio;
    private double igv;
    private double total;
    private Terreno terreno;

    public Recibo(){
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public double getInteres_moratorio() {
        return interes_moratorio;
    }

    public void setInteres_moratorio(double interes_moratorio) {
        this.interes_moratorio = interes_moratorio;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
}
