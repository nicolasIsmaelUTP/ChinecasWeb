package com.nibble.chinecas.api;

public class ItemRecibo {
    private String descripcion;
    private int anio;
    private double valor_metro_cubico;
    private double volumen_utilizado;
    private int lectura_id;

    public ItemRecibo() {
    }

    public ItemRecibo(String descripcion, int anio, double valor_metro_cubico, double volumen_utilizado, int lectura_id) {
        this.descripcion = descripcion;
        this.anio = anio;
        this.valor_metro_cubico = valor_metro_cubico;
        this.volumen_utilizado = volumen_utilizado;
        this.lectura_id = lectura_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getValor_metro_cubico() {
        return valor_metro_cubico;
    }

    public void setValor_metro_cubico(double valor_metro_cubico) {
        this.valor_metro_cubico = valor_metro_cubico;
    }

    public double getVolumen_utilizado() {
        return volumen_utilizado;
    }

    public void setVolumen_utilizado(double volumen_utilizado) {
        this.volumen_utilizado = volumen_utilizado;
    }

    public int getLectura_id() {
        return lectura_id;
    }

    public void setLectura_id(int lectura_id) {
        this.lectura_id = lectura_id;
    }
}