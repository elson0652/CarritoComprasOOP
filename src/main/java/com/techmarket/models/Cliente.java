package com.techmarket.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Carrito> historialCompras;
    private String direccionEnvio;
    private String telefono;

    public Cliente(int id, String nombre, String email, String contrasena,
                  String direccionEnvio, String telefono) {
        super(id, nombre, email, contrasena);
        this.historialCompras = new ArrayList<>();
        this.direccionEnvio = direccionEnvio;
        this.telefono = telefono;
    }

    public List<Carrito> getHistorialCompras() {
        return new ArrayList<>(historialCompras);
    }

    public void agregarCompra(Carrito carrito) {
        historialCompras.add(carrito);
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }

    @Override
    public String toString() {
        return super.toString().replace("}", 
                ", direccionEnvio='" + direccionEnvio + '\'' +
                ", telefono='" + telefono + '\'' +
                ", comprasRealizadas=" + historialCompras.size() +
                '}');
    }
}