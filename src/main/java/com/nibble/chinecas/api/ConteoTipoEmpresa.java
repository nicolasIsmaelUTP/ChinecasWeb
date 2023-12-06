package com.nibble.chinecas.api;

public class ConteoTipoEmpresa {
    private String nombre_tipo_empresa;
    private String descripcion_tipo_empresa;
    private int cantidad_empresas;

    public ConteoTipoEmpresa() {

    }

    public ConteoTipoEmpresa(String nombre_tipo_empresa, String descripcion_tipo_empresa, int cantidad_empresas) {
        this.nombre_tipo_empresa = nombre_tipo_empresa;
        this.descripcion_tipo_empresa = descripcion_tipo_empresa;
        this.cantidad_empresas = cantidad_empresas;
    }

    public String getNombre_tipo_empresa() {
        return nombre_tipo_empresa;
    }

    public void setNombre_tipo_empresa(String nombre_tipo_empresa) {
        this.nombre_tipo_empresa = nombre_tipo_empresa;
    }

    public String getDescripcion_tipo_empresa() {
        return descripcion_tipo_empresa;
    }

    public void setDescripcion_tipo_empresa(String descripcion_tipo_empresa) {
        this.descripcion_tipo_empresa = descripcion_tipo_empresa;
    }

    public int getCantidad_empresas() {
        return cantidad_empresas;
    }

    public void setCantidad_empresas(int cantidad_empresas) {
        this.cantidad_empresas = cantidad_empresas;
    }
}
