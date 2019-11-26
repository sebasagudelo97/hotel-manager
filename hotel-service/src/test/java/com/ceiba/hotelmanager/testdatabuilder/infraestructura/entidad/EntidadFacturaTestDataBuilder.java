package com.ceiba.hotelmanager.testdatabuilder.infraestructura.entidad;

import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.infraestructura.entidad.FacturaEntidad;

import java.time.LocalDate;

public class EntidadFacturaTestDataBuilder {

    private static final int ID_FACTURA=1;
    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,19);
    private static final int VALOR_PAGAR=37200;

    private int idFactura;
    private LocalDate fechaIngreso;
    private int valorPagar;

    public EntidadFacturaTestDataBuilder(){
        this.idFactura=ID_FACTURA;
        this.fechaIngreso=FECHA_INGRESO;
        this.valorPagar=VALOR_PAGAR;
    }

    public EntidadFacturaTestDataBuilder conIdFactura(int idFactura){
        this.idFactura=idFactura;
        return this;
    }

    public EntidadFacturaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso=fechaIngreso;
        return this;
    }

    public EntidadFacturaTestDataBuilder conValorPagar(int valorPagar){
        this.valorPagar=valorPagar;
        return this;
    }

    public FacturaEntidad build(){
        return new FacturaEntidad(this.fechaIngreso,this.valorPagar);
    }
}
