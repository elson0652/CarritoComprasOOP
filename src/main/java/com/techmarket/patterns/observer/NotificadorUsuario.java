package com.techmarket.patterns.observer;

import com.techmarket.models.Usuario;

/**
 * Observer específico para notificaciones de usuario
 */
public class NotificadorUsuario implements Observer {
    private String nombre;
    
    public NotificadorUsuario(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void actualizar(String evento, Object datos) {
        switch (evento) {
            case "USUARIO_REGISTRADO":
                if (datos instanceof Usuario) {
                    Usuario usuario = (Usuario) datos;
                    System.out.println("👤 [" + nombre + "] Nuevo usuario registrado: " + 
                                     usuario.getNombre() + " (" + usuario.getTipoUsuario() + ")");
                }
                break;
                
            case "USUARIO_LOGIN":
                if (datos instanceof Usuario) {
                    Usuario usuario = (Usuario) datos;
                    System.out.println("🔐 [" + nombre + "] Usuario conectado: " + usuario.getNombre());
                }
                break;
                
            case "USUARIO_LOGOUT":
                if (datos instanceof Usuario) {
                    Usuario usuario = (Usuario) datos;
                    System.out.println("🚪 [" + nombre + "] Usuario desconectado: " + usuario.getNombre());
                }
                break;
                
            default:
                System.out.println("📋 [" + nombre + "] Evento de usuario: " + evento);
        }
    }
    
    public String getNombre() {
        return nombre;
    }
}