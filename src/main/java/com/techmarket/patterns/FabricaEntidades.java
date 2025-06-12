package com.techmarket.patterns;

import com.techmarket.models.*;

/**
 * Patrón Factory para creación de entidades del sistema
 */
public class FabricaEntidades {
    
    // Enums para tipos de entidades
    public enum TipoProducto {
        FISICO, DIGITAL
    }
    
    public enum TipoUsuario {
        CLIENTE, ADMINISTRADOR
    }
    
    /**
     * Factory Method para crear productos
     */
    public static Producto crearProducto(TipoProducto tipo, int id, String nombre, 
                                       String descripcion, double precio, int stock, 
                                       Object... parametrosEspecificos) {
        switch (tipo) {
            case FISICO:
                if (parametrosEspecificos.length >= 4) {
                    double peso = (Double) parametrosEspecificos[0];
                    double alto = (Double) parametrosEspecificos[1];
                    double ancho = (Double) parametrosEspecificos[2];
                    double profundidad = (Double) parametrosEspecificos[3];
                    
                    return new ProductoFisico(id, nombre, descripcion, precio, stock,
                                            peso, alto, ancho, profundidad);
                }
                throw new IllegalArgumentException("Parámetros insuficientes para ProductoFisico");
                
            case DIGITAL:
                if (parametrosEspecificos.length >= 3) {
                    String formato = (String) parametrosEspecificos[0];
                    double tamanoMB = (Double) parametrosEspecificos[1];
                    String urlDescarga = (String) parametrosEspecificos[2];
                    
                    return new ProductoDigital(id, nombre, descripcion, precio, stock,
                                             formato, tamanoMB, urlDescarga);
                }
                throw new IllegalArgumentException("Parámetros insuficientes para ProductoDigital");
                
            default:
                throw new IllegalArgumentException("Tipo de producto no soportado: " + tipo);
        }
    }
    
    /**
     * Factory Method para crear usuarios
     */
    public static Usuario crearUsuario(TipoUsuario tipo, int id, String nombre, 
                                     String email, String contrasena, 
                                     Object... parametrosEspecificos) {
        switch (tipo) {
            case CLIENTE:
                if (parametrosEspecificos.length >= 2) {
                    String direccionEnvio = (String) parametrosEspecificos[0];
                    String telefono = (String) parametrosEspecificos[1];
                    
                    return new Cliente(id, nombre, email, contrasena, direccionEnvio, telefono);
                }
                throw new IllegalArgumentException("Parámetros insuficientes para Cliente");
                
            case ADMINISTRADOR:
                if (parametrosEspecificos.length >= 2) {
                    String rol = (String) parametrosEspecificos[0];
                    String departamento = (String) parametrosEspecificos[1];
                    
                    return new Administrador(id, nombre, email, contrasena, rol, departamento);
                }
                throw new IllegalArgumentException("Parámetros insuficientes para Administrador");
                
            default:
                throw new IllegalArgumentException("Tipo de usuario no soportado: " + tipo);
        }
    }
    
    /**
     * Factory Method simplificado para productos físicos
     */
    public static ProductoFisico crearProductoFisico(int id, String nombre, String descripcion,
                                                   double precio, int stock, double peso,
                                                   double alto, double ancho, double profundidad) {
        return (ProductoFisico) crearProducto(TipoProducto.FISICO, id, nombre, descripcion, 
                                            precio, stock, peso, alto, ancho, profundidad);
    }
    
    /**
     * Factory Method simplificado para productos digitales
     */
    public static ProductoDigital crearProductoDigital(int id, String nombre, String descripcion,
                                                     double precio, int stock, String formato,
                                                     double tamanoMB, String urlDescarga) {
        return (ProductoDigital) crearProducto(TipoProducto.DIGITAL, id, nombre, descripcion,
                                             precio, stock, formato, tamanoMB, urlDescarga);
    }
    
    /**
     * Factory Method simplificado para clientes
     */
    public static Cliente crearCliente(int id, String nombre, String email, String contrasena,
                                     String direccionEnvio, String telefono) {
        return (Cliente) crearUsuario(TipoUsuario.CLIENTE, id, nombre, email, contrasena,
                                    direccionEnvio, telefono);
    }
    
    /**
     * Factory Method simplificado para administradores
     */
    public static Administrador crearAdministrador(int id, String nombre, String email, 
                                                 String contrasena, String rol, String departamento) {
        return (Administrador) crearUsuario(TipoUsuario.ADMINISTRADOR, id, nombre, email, 
                                          contrasena, rol, departamento);
    }
    
    /**
     * Método para validar parámetros comunes
     */
    private static void validarParametrosComunes(int id, String nombre, String descripcion, double precio) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}