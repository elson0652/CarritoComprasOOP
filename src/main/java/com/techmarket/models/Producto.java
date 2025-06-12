package com.techmarket.models;

public abstract class Producto extends Item {
    private int stock;

    public Producto(int id, String nombre, String descripcion, double precio, int stock) {
        super(id, nombre, descripcion, precio);
        setStock(stock);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    public boolean reducirStock(int cantidad) {
        if (cantidad <= this.stock && cantidad > 0) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String getTipo() {
        return getTipoProducto();
    }

    public abstract String getTipoProducto();

    @Override
    public String getDetalles() {
        return String.format("ID: %d | %s - %s | Precio: $%.2f | Stock: %d",
                getId(), getNombre(), getDescripcion(), getPrecio(), stock);
    }

    // Método para mostrar detalles (usado en las subclases)
    public String mostrarDetalle() {
        return getDetalles();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", precio=" + getPrecio() +
                ", stock=" + stock +
                '}';
    }
}