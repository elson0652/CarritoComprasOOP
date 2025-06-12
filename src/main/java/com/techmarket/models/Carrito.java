package com.techmarket.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Carrito {
    private List<Producto> productos;
    private Map<Integer, Integer> cantidades; // Map<ProductoId, Cantidad>
    private double total;

    public Carrito() {
        this.productos = new ArrayList<>();
        this.cantidades = new HashMap<>();
        this.total = 0.0;
    }

    // Sobrecarga de métodos para agregar productos
    public boolean agregarProducto(Producto producto) {
        return agregarProducto(producto, 1);
    }

    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto != null && producto.getStock() >= cantidad && cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                productos.add(producto);
            }
            cantidades.merge(producto.getId(), cantidad, Integer::sum);
            producto.reducirStock(cantidad);
            total += producto.getPrecio() * cantidad;
            return true;
        }
        return false;
    }

    public boolean agregarProducto(int id, String nombre, double precio, int cantidad) {
        // Simulación de búsqueda de producto por ID (en un sistema real, esto vendría de una base de datos)
        Producto producto = productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        
        if (producto != null) {
            return agregarProducto(producto, cantidad);
        }
        return false;
    }

    public boolean eliminarProducto(Producto producto) {
        return eliminarProducto(producto, 1);
    }

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
                cantidades.merge(producto.getId(), -encontrados, (old, delta) -> 
                    old + delta <= 0 ? null : old + delta);
                producto.setStock(producto.getStock() + encontrados);
                total -= producto.getPrecio() * encontrados;
                return true;
            }
        }
        return false;
    }

    public double getTotal() {
        return total;
    }

    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public void limpiarCarrito() {
        for (Producto producto : productos) {
            int cantidad = cantidades.getOrDefault(producto.getId(), 0);
            producto.setStock(producto.getStock() + cantidad);
        }
        productos.clear();
        cantidades.clear();
        total = 0.0;
    }

    public void mostrarCarrito() {
        System.out.println("\n=== Contenido del Carrito ===");
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }

        productos.stream()
                .distinct()
                .forEach(p -> {
                    int cantidad = cantidades.getOrDefault(p.getId(), 0);
                    System.out.println(p.mostrarDetalle());
                    System.out.printf("Cantidad: %d | Subtotal: $%.2f%n",
                            cantidad, p.getPrecio() * cantidad);
                });
        System.out.printf("Total: $%.2f%n", total);
    }
}