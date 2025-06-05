package com.techmarket.models.payment;

public interface ProcesoPago {
    boolean iniciarPago(double monto);
    boolean verificarPago(String referenciaPago);
    boolean confirmarPago(String referenciaPago);
    void cancelarPago(String referenciaPago);
    String getEstadoPago(String referenciaPago);
}