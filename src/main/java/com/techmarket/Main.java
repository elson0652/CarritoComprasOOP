package com.techmarket;

import com.techmarket.models.Producto;
import com.techmarket.models.Usuario;
import com.techmarket.models.Carrito;

public class Main {
    public static void main(String[] args) {
        // Crear algunos productos
        Producto laptop = new Producto(1, "Laptop", "Laptop gaming", 999.99, 5);
        Producto telefono = new Producto(2, "Teléfono", "Smartphone último modelo", 599.99, 10);
        
        // Crear un usuario
        Usuario usuario = new Usuario(1, "Juan Pérez", "juan@email.com", "contraseña123");
        
        // Crear un carrito
        Carrito carrito = new Carrito();
        
        // Realizar algunas operaciones
        System.out.println("=== Demo TechMarket ===");
        
        System.out.println("\nAgregando productos al carrito:");
        carrito.agregarProducto(laptop, 2);
        carrito.agregarProducto(telefono, 1);
        carrito.mostrarCarrito();
        
        System.out.println("\nEliminando un producto:");
        carrito.eliminarProducto(laptop, 1);
        carrito.mostrarCarrito();
        
        System.out.println("\nStock restante:");
        System.out.println("Laptops: " + laptop.getStock());
        System.out.println("Teléfonos: " + telefono.getStock());
    }
}