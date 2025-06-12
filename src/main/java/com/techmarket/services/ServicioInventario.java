package com.techmarket.services;

import com.techmarket.models.Producto;
import com.techmarket.patterns.observer.GestorEventos;

/**
 * Servicio de inventario que integra el patrón Observer
 */
public class ServicioInventario {
    private GestorEventos gestorEventos;
    private int umbralStockBajo;
    
    public ServicioInventario(GestorEventos gestorEventos) {
        this.gestorEventos = gestorEventos;
        this.umbralStockBajo = 5; // Stock bajo cuando queden 5 o menos unidades
    }
    
    public void actualizarStock(Producto producto, int nuevoStock) {
        int stockAnterior = producto.getStock();
        producto.setStock(nuevoStock);
        
        // Publicar evento de actualización
        gestorEventos.publicarEvento("STOCK_ACTUALIZADO", producto);
        
        // Verificar condiciones especiales
        if (nuevoStock == 0 && stockAnterior > 0) {
            gestorEventos.publicarEvento("PRODUCTO_AGOTADO", producto);
        } else if (nuevoStock <= umbralStockBajo && nuevoStock > 0) {
            gestorEventos.publicarEvento("STOCK_BAJO", producto);
        }
    }
    
    public void reducirStock(Producto producto, int cantidad) {
        if (producto.reducirStock(cantidad)) {
            gestorEventos.publicarEvento("STOCK_ACTUALIZADO", producto);
            
            if (producto.getStock() == 0) {
                gestorEventos.publicarEvento("PRODUCTO_AGOTADO", producto);
            } else if (producto.getStock() <= umbralStockBajo) {
                gestorEventos.publicarEvento("STOCK_BAJO", producto);
            }
        }
    }
    
    public void setUmbralStockBajo(int umbral) {
        this.umbralStockBajo = umbral;
    }
    
    public int getUmbralStockBajo() {
        return umbralStockBajo;
    }
}