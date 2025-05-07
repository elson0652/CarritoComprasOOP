package com.techmarket.models;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;
    private double total;

    // Constructor
    public Carrito() {
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    // Método para agregar producto
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto != null && producto.getStock() >= cantidad && cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                productos.add(producto);
            }
            producto.reducirStock(cantidad);
            total += producto.getPrecio() * cantidad;
            return true;
        }
        return false;
    }

    // Método para eliminar producto
    public boolean eliminarProducto(Producto producto, int cantidad) {
        int encontrados = 0;
        if (producto != null && cantidad > 0) {
            for (int i = productos.size() - 1; i >= 0 && encontrados < cantidad; i--) {
                if (productos.get(i).getId() == producto.getId()) {
                    productos.remove(i);
                    encontrados++;
                }
            }
            if (encontrados > 0) {
                producto.setStock(producto.getStock() + encontrados);
                total -= producto.getPrecio() * encontrados;
                return true;
            }
        }
        return false;
    }

    // Obtener total
    public double getTotal() {
        return total;
    }

    // Obtener productos
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    // Limpiar carrito
    public void limpiarCarrito() {
        for (Producto producto : productos) {
            producto.setStock(producto.getStock() + 1);
        }
        productos.clear();
        total = 0.0;
    }

    // Mostrar contenido del carrito
    public void mostrarCarrito() {
        System.out.println("\n=== Contenido del Carrito ===");
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }

        productos.stream()
                .distinct()
                .forEach(p -> {
                    long cantidad = productos.stream()
                            .filter(prod -> prod.getId() == p.getId())
                            .count();
                    System.out.printf("- %s (x%d) | $%.2f c/u | Subtotal: $%.2f%n",
                            p.getNombre(), cantidad, p.getPrecio(), p.getPrecio() * cantidad);
                });
        System.out.printf("Total: $%.2f%n", total);
    }
}