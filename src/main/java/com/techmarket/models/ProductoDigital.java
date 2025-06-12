package com.techmarket.models;

public class ProductoDigital extends Producto {
    private String formato;
    private double tamanoMB;
    private String urlDescarga;

    public ProductoDigital(int id, String nombre, String descripcion, double precio, int stock,
                         String formato, double tamanoMB, String urlDescarga) {
        super(id, nombre, descripcion, precio, stock);
        this.formato = formato;
        this.tamanoMB = tamanoMB;
        this.urlDescarga = urlDescarga;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamanoMB() {
        return tamanoMB;
    }

    public void setTamanoMB(double tamanoMB) {
        if (tamanoMB > 0) {
            this.tamanoMB = tamanoMB;
        }
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }

    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = urlDescarga;
    }

    @Override
    public String getTipoProducto() {
        return "Digital";
    }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle() + 
               String.format(" | Formato: %s | Tamaño: %.2f MB | URL: %s",
                           formato, tamanoMB, urlDescarga);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", 
                ", formato='" + formato + '\'' +
                ", tamanoMB=" + tamanoMB +
                ", urlDescarga='" + urlDescarga + '\'' +
                '}');
    }
}