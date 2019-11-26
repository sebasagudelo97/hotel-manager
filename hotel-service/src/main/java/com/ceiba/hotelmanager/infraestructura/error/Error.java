package com.ceiba.hotelmanager.infraestructura.error;

import lombok.Getter;

@Getter
public class Error {

    private String nombreExcepcion;
    private String mensajeExcepcion;

    public Error(String nombreExcepcion, String mensajeExcepcion) {
        this.nombreExcepcion = nombreExcepcion;
        this.mensajeExcepcion = mensajeExcepcion;
    }

}
