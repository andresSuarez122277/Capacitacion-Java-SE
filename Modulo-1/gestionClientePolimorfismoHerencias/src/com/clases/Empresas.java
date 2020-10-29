package com.clases;

public class Empresas extends Clientes{

    private String representante;

    public Empresas(String tipoDoc, String documento, String nombre, String telefono, String direccion, String representante) {
        super(tipoDoc, documento, nombre, telefono, direccion);
        this.representante = representante;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Representante= " + representante;
    }
}
