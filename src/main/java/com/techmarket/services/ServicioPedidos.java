package com.techmarket.services;

import com.techmarket.models.Carrito;
import com.techmarket.models.Usuario;
import com.techmarket.patterns.observer.GestorEventos;

/**
 * Servicio de pedidos que integra el patrón Observer
 */
public class ServicioPedidos {
    private GestorEventos gestorEventos;
    
    public ServicioPedidos(GestorEventos gestorEventos) {
        this.gestorEventos = gestorEventos;
    }
    
    public void crearPedido(Carrito carrito, Usuario usuario) {
        // Lógica de creación de pedido
        gestorEventos.publicarEvento("PEDIDO_CREADO", carrito);
    }
    
    public void confirmarPedido(String pedidoId) {
        // Lógica de confirmación
        gestorEventos.publicarEvento("PEDIDO_CONFIRMADO", pedidoId);
    }
    
    public void enviarPedido(String pedidoId) {
        // Lógica de envío
        gestorEventos.publicarEvento("PEDIDO_ENVIADO", pedidoId);
    }
    
    public void entregarPedido(String pedidoId) {
        // Lógica de entrega
        gestorEventos.publicarEvento("PEDIDO_ENTREGADO", pedidoId);
    }
    
    public void cancelarPedido(String pedidoId) {
        // Lógica de cancelación
        gestorEventos.publicarEvento("PEDIDO_CANCELADO", pedidoId);
    }
}