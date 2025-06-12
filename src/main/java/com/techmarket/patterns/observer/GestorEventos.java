package com.techmarket.patterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Gestor central de eventos usando patrón Observer
 */
public class GestorEventos implements Subject {
    private Map<String, List<Observer>> observers;
    
    public GestorEventos() {
        this.observers = new HashMap<>();
    }
    
    @Override
    public void agregarObserver(Observer observer) {
        agregarObserver("GENERAL", observer);
    }
    
    public void agregarObserver(String tipoEvento, Observer observer) {
        observers.computeIfAbsent(tipoEvento, k -> new ArrayList<>()).add(observer);
    }
    
    @Override
    public void eliminarObserver(Observer observer) {
        observers.values().forEach(lista -> lista.remove(observer));
    }
    
    public void eliminarObserver(String tipoEvento, Observer observer) {
        List<Observer> lista = observers.get(tipoEvento);
        if (lista != null) {
            lista.remove(observer);
        }
    }
    
    @Override
    public void notificarObservers(String evento, Object datos) {
        // Notificar observers específicos del evento
        List<Observer> observersEspecificos = observers.get(evento);
        if (observersEspecificos != null) {
            observersEspecificos.forEach(observer -> observer.actualizar(evento, datos));
        }
        
        // Notificar observers generales
        List<Observer> observersGenerales = observers.get("GENERAL");
        if (observersGenerales != null) {
            observersGenerales.forEach(observer -> observer.actualizar(evento, datos));
        }
    }
    
    public void publicarEvento(String evento, Object datos) {
        System.out.println("📢 Evento publicado: " + evento);
        notificarObservers(evento, datos);
    }
    
    public int contarObservers(String tipoEvento) {
        List<Observer> lista = observers.get(tipoEvento);
        return lista != null ? lista.size() : 0;
    }
    
    public void mostrarEstadisticas() {
        System.out.println("\n=== Estadísticas del Gestor de Eventos ===");
        observers.forEach((evento, lista) -> 
            System.out.println("Evento '" + evento + "': " + lista.size() + " observers"));
    }
}