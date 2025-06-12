package com.techmarket.patterns.observer;

/**
 * Interfaz Subject para el patrón Observer
 */
public interface Subject {
    void agregarObserver(Observer observer);
    void eliminarObserver(Observer observer);
    void notificarObservers(String evento, Object datos);
}