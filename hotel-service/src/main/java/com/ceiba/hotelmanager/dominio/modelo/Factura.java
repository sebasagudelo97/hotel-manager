package com.ceiba.hotelmanager.dominio.modelo;

import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;

import java.time.LocalDate;

public class Factura {

    private static final String EL_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";

    private int idFactura;
    private LocalDate fechaRegistro;
    private int valorPagar;

    public Factura(LocalDate fechaRegistro, int valorPagar) {
        ValidadorArgumento.validarCampoObligatorio(valorPagar,EL_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(fechaRegistro,EL_CAMPO_DEBE_SER_OBLIGATORIO);

        this.fechaRegistro = fechaRegistro;
        this.valorPagar = valorPagar;
    }

    public Factura(){}
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
