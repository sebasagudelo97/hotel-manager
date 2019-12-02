package com.ceiba.hotelmanager.testdatabuilder.dominio.modelo;

import com.ceiba.hotelmanager.dominio.modelo.Factura;

import java.time.LocalDate;

public class FacturaTestDataBuilder {
    private static final LocalDate FECHA_REGISTRO = LocalDate.now();
    private static final int VALOR_PAGAR=37200;

    private LocalDate fechaRegistro;
    private int valorPagar;

    public FacturaTestDataBuilder(){
        this.fechaRegistro=FECHA_REGISTRO;
        this.valorPagar=VALOR_PAGAR;
    }

    public FacturaTestDataBuilder conFechaRegistro(LocalDate fechaRegistro){
        this.fechaRegistro=fechaRegistro;
        return this;
    }

    public FacturaTestDataBuilder conValorPagar(int valorPagar){
        this.valorPagar=valorPagar;
        return this;
    }

    public Factura build(){
        return new Factura(this.fechaRegistro,this.valorPagar);
    }
}
