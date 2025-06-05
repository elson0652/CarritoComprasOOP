package com.techmarket.models.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PagoPayPal implements ProcesoPago {
    private Map<String, EstadoPago> pagos;
    
    public PagoPayPal() {
        this.pagos = new HashMap<>();
    }
    
    @Override
    public boolean iniciarPago(double monto) {
        if (monto <= 0) {
            return false;
        }
        
        String referencia = UUID.randomUUID().toString();
        pagos.put(referencia, new EstadoPago(monto, "PENDIENTE"));
        return true;
    }
    
    @Override
    public boolean verificarPago(String referenciaPago) {
        EstadoPago estado = pagos.get(referenciaPago);
        return estado != null && "AUTORIZADO".equals(estado.estado);
    }
    
    @Override
    public boolean confirmarPago(String referenciaPago) {
        EstadoPago estado = pagos.get(referenciaPago);
        if (estado != null && "AUTORIZADO".equals(estado.estado)) {
            estado.estado = "COMPLETADO";
            return true;
        }
        return false;
    }
    
    @Override
    public void cancelarPago(String referenciaPago) {
        EstadoPago estado = pagos.get(referenciaPago);
        if (estado != null) {
            estado.estado = "CANCELADO";
        }
    }
    
    @Override
    public String getEstadoPago(String referenciaPago) {
        EstadoPago estado = pagos.get(referenciaPago);
        return estado != null ? estado.estado : "NO_ENCONTRADO";
    }
    
    private static class EstadoPago {
        double monto;
        String estado;
        
        EstadoPago(double monto, String estado) {
            this.monto = monto;
            this.estado = estado;
        }
    }
}