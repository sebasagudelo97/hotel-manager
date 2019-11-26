package com.ceiba.hotelmanager.infraestructura.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "factura")
public class FacturaEntidad {

    @Id
    @GeneratedValue
    @Column(name = "in_codigo")
    private int idFactura;

    @Column(name = "date_fecha_registro", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaRegistro;

    @Column(name = "int_valor_pagar", nullable = false)
    private int valorPagar;

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

    public FacturaEntidad(LocalDate fechaRegistro, int valorPagar) {
        this.fechaRegistro = fechaRegistro;
        this.valorPagar = valorPagar;
    }

    public FacturaEntidad(){}
}
