package com.techmarket.patterns.observer;

import com.techmarket.models.Carrito;

/**
 * Observer específico para notificaciones de pedidos
 */
public class NotificadorPedidos implements Observer {
    private String nombre;
    
    public NotificadorPedidos(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void actualizar(String evento, Object datos) {
        switch (evento) {
            case "PEDIDO_CREADO":
                if (datos instanceof Carrito) {
                    Carrito carrito = (Carrito) datos;
                    System.out.println("🛒 [" + nombre + "] Nuevo pedido creado - Total: $" + 
                                     String.format("%.2f", carrito.getTotal()));
                }
                break;
                
            case "PEDIDO_CONFIRMADO":
                System.out.println("✅ [" + nombre + "] Pedido confirmado y en proceso");
                break;
                
            case "PEDIDO_ENVIADO":
                System.out.println("📦 [" + nombre + "] Pedido enviado al cliente");
                break;
                
            case "PEDIDO_ENTREGADO":
                System.out.println("🎉 [" + nombre + "] Pedido entregado exitosamente");
                break;
                
            case "PEDIDO_CANCELADO":
                System.out.println("❌ [" + nombre + "] Pedido cancelado");
                break;
                
            default:
                System.out.println("📋 [" + nombre + "] Evento de pedido: " + evento);
        }
    }
    
    public String getNombre() {
        return nombre;
    }
}