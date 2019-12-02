package com.ceiba.hotelmanager.dominio.modelo.dto;

import java.time.LocalDate;

public class FacturaDto {

    private int idFactura;
    private LocalDate fechaRegistro;
    private int valorPagar;

    public FacturaDto(){
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(int valorPagar) {
        this.valorPagar = valorPagar;
    }
}
