package com.techmarket.models.inventory;

import com.techmarket.models.Producto;
import com.techmarket.models.ProductoDigital;
import java.util.HashMap;
import java.util.Map;

public class InventarioDigital extends GestorInventario {
    private Map<Integer, Integer> inventario;
    
    public InventarioDigital(int capacidadMaxima) {
        super(capacidadMaxima);
        this.inventario = new HashMap<>();
    }
    
    @Override
    public boolean añadirProducto(Producto producto, int cantidad) {
        if (!(producto instanceof ProductoDigital)) {
            return false;
        }
        
        int stockActual = inventario.getOrDefault(producto.getId(), 0);
        inventario.put(producto.getId(), stockActual + cantidad);
        return true;
    }
    
    @Override
    public boolean eliminarProducto(Producto producto, int cantidad) {
        int stockActual = inventario.getOrDefault(producto.getId(), 0);
        if (stockActual < cantidad) {
            return false;
        }
        
        int nuevoStock = stockActual - cantidad;
        if (nuevoStock == 0) {
            inventario.remove(producto.getId());
        } else {
            inventario.put(producto.getId(), nuevoStock);
        }
        return true;
    }
    
    @Override
    public boolean actualizarStock(Producto producto, int nuevoStock) {
        if (nuevoStock < 0) {
            return false;
        }
        
        if (nuevoStock == 0) {
            inventario.remove(producto.getId());
        } else {
            inventario.put(producto.getId(), nuevoStock);
        }
        return true;
    }
    
    @Override
    public int consultarStock(Producto producto) {
        return inventario.getOrDefault(producto.getId(), 0);
    }
}