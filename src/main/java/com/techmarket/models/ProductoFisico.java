package com.techmarket.models;

public class ProductoFisico extends Producto {
    private double peso;
    private double alto;
    private double ancho;
    private double profundidad;

    public ProductoFisico(int id, String nombre, String descripcion, double precio, int stock,
                         double peso, double alto, double ancho, double profundidad) {
        super(id, nombre, descripcion, precio, stock);
        this.peso = peso;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        if (alto > 0) {
            this.alto = alto;
        }
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        if (profundidad > 0) {
            this.profundidad = profundidad;
        }
    }

    public double getVolumen() {
        return alto * ancho * profundidad;
    }

    @Override
    public String getTipoProducto() {
        return "Físico";
    }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle() + 
               String.format(" | Peso: %.2f kg | Dimensiones: %.2fx%.2fx%.2f cm | Volumen: %.2f cm³",
                           peso, alto, ancho, profundidad, getVolumen());
    }

    @Override
    public String toString() {
        return super.toString().replace("}", 
                ", peso=" + peso +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", profundidad=" + profundidad +
                ", volumen=" + getVolumen() +
                '}');
    }
}