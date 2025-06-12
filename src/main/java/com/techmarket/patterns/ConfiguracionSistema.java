package com.techmarket.patterns;

import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Patrón Singleton para gestión de configuración del sistema
 * Thread-safe usando double-checked locking
 */
public class ConfiguracionSistema {
    private static volatile ConfiguracionSistema instancia;
    private static final ReentrantLock lock = new ReentrantLock();
    
    private Properties configuraciones;
    private String nombreSistema;
    private String version;
    private int maxConexionesBD;
    private String urlBaseDatos;
    private boolean modoDebug;
    private double impuestoDefecto;
    private String monedaDefecto;
    
    // Constructor privado para prevenir instanciación externa
    private ConfiguracionSistema() {
        inicializarConfiguraciones();
    }
    
    /**
     * Método para obtener la única instancia (Thread-safe)
     */
    public static ConfiguracionSistema obtenerInstancia() {
        if (instancia == null) {
            lock.lock();
            try {
                if (instancia == null) {
                    instancia = new ConfiguracionSistema();
                }
            } finally {
                lock.unlock();
            }
        }
        return instancia;
    }
    
    private void inicializarConfiguraciones() {
        configuraciones = new Properties();
        
        // Configuraciones por defecto
        nombreSistema = "TechMarket E-Commerce";
        version = "1.0.0";
        maxConexionesBD = 50;
        urlBaseDatos = "jdbc:mysql://localhost:3306/techmarket";
        modoDebug = false;
        impuestoDefecto = 0.16; // 16% IVA
        monedaDefecto = "USD";
        
        // Cargar en Properties
        configuraciones.setProperty("sistema.nombre", nombreSistema);
        configuraciones.setProperty("sistema.version", version);
        configuraciones.setProperty("bd.maxConexiones", String.valueOf(maxConexionesBD));
        configuraciones.setProperty("bd.url", urlBaseDatos);
        configuraciones.setProperty("sistema.debug", String.valueOf(modoDebug));
        configuraciones.setProperty("comercio.impuesto", String.valueOf(impuestoDefecto));
        configuraciones.setProperty("comercio.moneda", monedaDefecto);
    }
    
    // Getters
    public String getNombreSistema() {
        return nombreSistema;
    }
    
    public String getVersion() {
        return version;
    }
    
    public int getMaxConexionesBD() {
        return maxConexionesBD;
    }
    
    public String getUrlBaseDatos() {
        return urlBaseDatos;
    }
    
    public boolean isModoDebug() {
        return modoDebug;
    }
    
    public double getImpuestoDefecto() {
        return impuestoDefecto;
    }
    
    public String getMonedaDefecto() {
        return monedaDefecto;
    }
    
    // Setters con validaciones
    public void setMaxConexionesBD(int maxConexiones) {
        if (maxConexiones > 0) {
            this.maxConexionesBD = maxConexiones;
            configuraciones.setProperty("bd.maxConexiones", String.valueOf(maxConexiones));
        }
    }
    
    public void setModoDebug(boolean debug) {
        this.modoDebug = debug;
        configuraciones.setProperty("sistema.debug", String.valueOf(debug));
    }
    
    public void setImpuestoDefecto(double impuesto) {
        if (impuesto >= 0 && impuesto <= 1) {
            this.impuestoDefecto = impuesto;
            configuraciones.setProperty("comercio.impuesto", String.valueOf(impuesto));
        }
    }
    
    public String obtenerConfiguracion(String clave) {
        return configuraciones.getProperty(clave);
    }
    
    public void establecerConfiguracion(String clave, String valor) {
        configuraciones.setProperty(clave, valor);
    }
    
    public void mostrarConfiguraciones() {
        System.out.println("=== Configuraciones del Sistema ===");
        System.out.println("Sistema: " + nombreSistema + " v" + version);
        System.out.println("Base de Datos: " + urlBaseDatos);
        System.out.println("Max Conexiones BD: " + maxConexionesBD);
        System.out.println("Modo Debug: " + modoDebug);
        System.out.println("Impuesto por defecto: " + (impuestoDefecto * 100) + "%");
        System.out.println("Moneda: " + monedaDefecto);
    }
    
    // Prevenir clonación
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("No se puede clonar una instancia Singleton");
    }
}