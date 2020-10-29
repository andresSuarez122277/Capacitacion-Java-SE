package com.clases;

public class Producto {
    private String nombre;
    private String carateristicas;
    private String idProducto;
    private String condiciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarateristicas() {
        return carateristicas;
    }

    public void setCarateristicas(String carateristicas) {
        this.carateristicas = carateristicas;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void generateId() {
        this.idProducto = String.valueOf(Double.valueOf(Math.random() * (500 - 100 + 1) + 100).intValue());
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + '\n' +
                "ID= " + idProducto + '\n' +
                "Carateristicas= " + carateristicas + '\n' +
                "Condiciones= " + condiciones + '\n';
    }
}
