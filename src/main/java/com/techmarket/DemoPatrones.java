package com.techmarket;

import com.techmarket.models.*;
import com.techmarket.patterns.*;
import com.techmarket.patterns.observer.*;
import com.techmarket.services.*;

/**
 * Clase de demostración para los patrones de diseño implementados
 */
public class DemoPatrones {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE PATRONES DE DISEÑO ===\n");
        
        // 1. PATRÓN SINGLETON - ConfiguracionSistema
        System.out.println("1. PATRÓN SINGLETON - Configuración del Sistema");
        System.out.println("=" .repeat(50));
        
        ConfiguracionSistema config1 = ConfiguracionSistema.obtenerInstancia();
        ConfiguracionSistema config2 = ConfiguracionSistema.obtenerInstancia();
        
        System.out.println("¿Son la misma instancia? " + (config1 == config2));
        config1.mostrarConfiguraciones();
        
        // Modificar configuración
        config1.setModoDebug(true);
        config1.setImpuestoDefecto(0.18);
        
        System.out.println("\nDespués de modificar config1:");
        config2.mostrarConfiguraciones(); // Debe mostrar los cambios
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 2. PATRÓN FACTORY - Creación de Entidades
        System.out.println("2. PATRÓN FACTORY - Creación de Entidades");
        System.out.println("=" .repeat(50));
        
        // Crear productos usando Factory
        Producto laptop = FabricaEntidades.crearProductoFisico(
            1, "Laptop Gaming", "Laptop de alto rendimiento", 
            1299.99, 10, 2.5, 1.5, 35.0, 25.0
        );
        
        Producto ebook = FabricaEntidades.crearProductoDigital(
            2, "Java Advanced Guide", "Guía avanzada de Java",
            49.99, 100, "PDF", 25.8, "https://ejemplo.com/java-advanced.pdf"
        );
        
        // Crear usuarios usando Factory
        Usuario cliente = FabricaEntidades.crearCliente(
            1, "María González", "maria@email.com", "password123",
            "Av. Principal 456", "555-0456"
        );
        
        Usuario admin = FabricaEntidades.crearAdministrador(
            2, "Carlos Admin", "carlos@techmarket.com", "admin123",
            "Supervisor", "IT"
        );
        
        System.out.println("Productos creados:");
        System.out.println("- " + laptop.getTipoProducto() + ": " + laptop.getNombre());
        System.out.println("- " + ebook.getTipoProducto() + ": " + ebook.getNombre());
        
        System.out.println("\nUsuarios creados:");
        System.out.println("- " + cliente.getTipoUsuario() + ": " + cliente.getNombre());
        System.out.println("- " + admin.getTipoUsuario() + ": " + admin.getNombre());
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // 3. PATRÓN OBSERVER - Sistema de Notificaciones
        System.out.println("3. PATRÓN OBSERVER - Sistema de Notificaciones");
        System.out.println("=" .repeat(50));
        
        // Crear gestor de eventos
        GestorEventos gestorEventos = new GestorEventos();
        
        // Crear observers
        NotificadorInventario notifInventario = new NotificadorInventario("Sistema Inventario");
        NotificadorPedidos notifPedidos = new NotificadorPedidos("Sistema Pedidos");
        NotificadorUsuario notifUsuario = new NotificadorUsuario("Sistema Usuarios");
        
        // Suscribir observers a eventos específicos
        gestorEventos.agregarObserver("STOCK_BAJO", notifInventario);
        gestorEventos.agregarObserver("STOCK_ACTUALIZADO", notifInventario);
        gestorEventos.agregarObserver("PRODUCTO_AGOTADO", notifInventario);
        
        gestorEventos.agregarObserver("PEDIDO_CREADO", notifPedidos);
        gestorEventos.agregarObserver("PEDIDO_CONFIRMADO", notifPedidos);
        gestorEventos.agregarObserver("PEDIDO_ENVIADO", notifPedidos);
        
        gestorEventos.agregarObserver("USUARIO_REGISTRADO", notifUsuario);
        gestorEventos.agregarObserver("USUARIO_LOGIN", notifUsuario);
        
        // Crear servicios que usan el gestor de eventos
        ServicioInventario servicioInventario = new ServicioInventario(gestorEventos);
        ServicioPedidos servicioPedidos = new ServicioPedidos(gestorEventos);
        
        System.out.println("Simulando eventos del sistema:\n");
        
        // Simular eventos de inventario
        System.out.println("--- Eventos de Inventario ---");
        servicioInventario.actualizarStock(laptop, 3); // Stock bajo
        servicioInventario.reducirStock(laptop, 3); // Producto agotado
        servicioInventario.actualizarStock(ebook, 50); // Actualización normal
        
        System.out.println("\n--- Eventos de Pedidos ---");
        // Simular eventos de pedidos
        Carrito carrito = new Carrito();
        carrito.agregarProducto(ebook, 2);
        
        servicioPedidos.crearPedido(carrito, cliente);
        servicioPedidos.confirmarPedido("PED-001");
        servicioPedidos.enviarPedido("PED-001");
        
        System.out.println("\n--- Eventos de Usuario ---");
        // Simular eventos de usuario
        gestorEventos.publicarEvento("USUARIO_REGISTRADO", cliente);
        gestorEventos.publicarEvento("USUARIO_LOGIN", admin);
        
        // Mostrar estadísticas
        System.out.println();
        gestorEventos.mostrarEstadisticas();
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("DEMOSTRACIÓN COMPLETADA");
        System.out.println("Los tres patrones han sido implementados exitosamente:");
        System.out.println("✅ Singleton: ConfiguracionSistema");
        System.out.println("✅ Factory: FabricaEntidades");
        System.out.println("✅ Observer: GestorEventos con notificadores especializados");
    }
}