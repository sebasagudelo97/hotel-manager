package com.ceiba.hotelmanager.dominio.excepcion;

public class ExcepcionCaracteres extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionCaracteres(String mensaje){
        super(mensaje);
    }
}
