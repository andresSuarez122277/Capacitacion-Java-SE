package com.clases;

public class Personas extends Clientes{

    private String celular;

    public Personas(String tipoDoc, String documento, String nombre, String telefono, String direccion, String celular) {
        super(tipoDoc, documento, nombre, telefono, direccion);
        this.celular = celular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Celular= " + celular;
    }
}
