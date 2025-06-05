package com.techmarket.models.inventory;

import com.techmarket.models.Producto;

public abstract class GestorInventario {
    protected int capacidadMaxima;
    
    public GestorInventario(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    public abstract boolean añadirProducto(Producto producto, int cantidad);
    public abstract boolean eliminarProducto(Producto producto, int cantidad);
    public abstract boolean actualizarStock(Producto producto, int nuevoStock);
    public abstract int consultarStock(Producto producto);
    
    protected boolean validarCapacidad(int cantidadActual, int cantidadNueva) {
        return (cantidadActual + cantidadNueva) <= capacidadMaxima;
    }
}