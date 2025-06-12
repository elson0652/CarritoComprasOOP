package com.techmarket.models;

import java.util.regex.Pattern;

public abstract class Usuario {
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    
    private int id;
    private String nombre;
    private String email;
    private String contrasena;

    public Usuario(int id, String nombre, String email, String contrasena) {
        this.id = id;
        setNombre(nombre);
        setEmail(email);
        setContrasena(contrasena);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && EMAIL_PATTERN.matcher(email).matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Formato de email inválido");
        }
    }

    protected String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena != null && contrasena.length() >= 8) {
            this.contrasena = contrasena;
        } else {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }
    }

    public abstract String getTipoUsuario();

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}