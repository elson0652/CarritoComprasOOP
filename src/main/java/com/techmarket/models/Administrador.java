package com.techmarket.models;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {
    private String rol;
    private List<String> permisos;
    private String departamento;

    public Administrador(int id, String nombre, String email, String contrasena,
                        String rol, String departamento) {
        super(id, nombre, email, contrasena);
        this.rol = rol;
        this.permisos = new ArrayList<>();
        this.departamento = departamento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<String> getPermisos() {
        return new ArrayList<>(permisos);
    }

    public void agregarPermiso(String permiso) {
        this.permisos.add(permiso);
    }

    public void quitarPermiso(String permiso) {
        this.permisos.remove(permiso);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void actualizarStock(Producto producto, int nuevoStock) {
        producto.setStock(nuevoStock);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }

    @Override
    public String toString() {
        return super.toString().replace("}", 
                ", rol='" + rol + '\'' +
                ", departamento='" + departamento + '\'' +
                ", permisos=" + permisos +
                '}');
    }
}