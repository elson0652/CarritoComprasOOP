package com.techmarket.patterns.observer;

import com.techmarket.models.Producto;

/**
 * Observer específico para notificaciones de inventario
 */
public class NotificadorInventario implements Observer {
    private String nombre;
    
    public NotificadorInventario(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void actualizar(String evento, Object datos) {
        switch (evento) {
            case "STOCK_BAJO":
                if (datos instanceof Producto) {
                    Producto producto = (Producto) datos;
                    System.out.println("🔔 [" + nombre + "] ALERTA: Stock bajo para " + 
                                     producto.getNombre() + " (Stock: " + producto.getStock() + ")");
                }
                break;
                
            case "PRODUCTO_AGOTADO":
                if (datos instanceof Producto) {
                    Producto producto = (Producto) datos;
                    System.out.println("⚠️ [" + nombre + "] CRÍTICO: Producto agotado - " + 
                                     producto.getNombre());
                }
                break;
                
            case "STOCK_ACTUALIZADO":
                if (datos instanceof Producto) {
                    Producto producto = (Producto) datos;
                    System.out.println("✅ [" + nombre + "] Stock actualizado para " + 
                                     producto.getNombre() + " (Nuevo stock: " + producto.getStock() + ")");
                }
                break;
                
            default:
                System.out.println("📋 [" + nombre + "] Evento de inventario: " + evento);
        }
    }
    
    public String getNombre() {
        return nombre;
    }
}