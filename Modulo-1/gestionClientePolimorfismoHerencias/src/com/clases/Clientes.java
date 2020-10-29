package com.clases;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private String tipoDoc;
    private String documento;
    private String nombre;
    private String telefono;
    private String direccion;
    private List<Producto> productos;

    public Clientes() {
    }

    public Clientes(String tipoDoc, String documento, String nombre, String telefono, String direccion) {
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        productos = new ArrayList<>();
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProductos() {
        String listaProductos = "";
        if(productos.size() > 0) {
            listaProductos = "\n\tProductos\n";
            for (Producto pro : productos) {
                listaProductos += pro.toString();
            }
        }else
            listaProductos = "Cliente sin productos.";
        return listaProductos;
    }

    public void addProductos(Producto producto) {
        this.productos.add(producto);
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + '\n' +
                "Tipo de documento= " + tipoDoc + '\n' +
                "Documento= " + documento + '\n' +
                "Telefono= " + telefono + '\n' +
                "Direccion= " + direccion + '\n';
    }
}
