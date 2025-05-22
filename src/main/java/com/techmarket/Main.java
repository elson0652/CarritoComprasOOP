package com.techmarket;

import com.techmarket.models.*;

public class Main {
    public static void main(String[] args) {
        // Crear productos
        ProductoFisico laptop = new ProductoFisico(1, "Laptop Gaming", "Laptop de alto rendimiento",
                999.99, 5, 2.5, 1.5, 35.0, 25.0);
        
        ProductoDigital ebook = new ProductoDigital(2, "Java Programming Guide",
                "Guía completa de programación en Java", 29.99, 100,
                "PDF", 15.5, "https://ejemplo.com/descargas/java-guide.pdf");

        // Crear usuarios
        Cliente cliente = new Cliente(1, "Juan Pérez", "juan@email.com", "contraseña123",
                "Calle Principal 123", "555-0123");
        
        Administrador admin = new Administrador(2, "Ana García", "ana@techmarket.com",
                "admin123", "Gerente", "Ventas");
        
        // Demostrar polimorfismo con productos
        System.out.println("=== Demostración de Polimorfismo ===\n");
        
        Producto[] productos = {laptop, ebook};
        for (Producto producto : productos) {
            System.out.println("Tipo de producto: " + producto.getTipoProducto());
            System.out.println(producto.mostrarDetalle() + "\n");
        }
        
        // Demostrar sobrecarga de métodos en Carrito
        System.out.println("=== Demostración de Sobrecarga de Métodos ===\n");
        
        Carrito carrito = new Carrito();
        
        // Diferentes formas de agregar productos
        carrito.agregarProducto(laptop); // Usando solo el producto
        carrito.agregarProducto(ebook, 2); // Usando producto y cantidad
        carrito.agregarProducto(1, "Laptop Gaming", 999.99, 1); // Usando ID, nombre y precio
        
        carrito.mostrarCarrito();
        
        // Simular compra
        cliente.agregarCompra(carrito);
        System.out.println("\nCompra registrada en el historial del cliente.");
        System.out.println("Número de compras realizadas: " + 
                cliente.getHistorialCompras().size());
        
        // Demostrar funcionalidad del administrador
        System.out.println("\nAdministrador actualizando stock:");
        admin.actualizarStock(laptop, 10);
        System.out.println("Nuevo stock de laptop: " + laptop.getStock());
    }
}