package com.techmarket.patterns.observer;

/**
 * Interfaz Observer para el patrón Observer
 */
public interface Observer {
    void actualizar(String evento, Object datos);
}