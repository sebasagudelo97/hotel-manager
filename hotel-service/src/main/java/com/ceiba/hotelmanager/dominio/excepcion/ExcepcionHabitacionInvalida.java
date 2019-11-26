package com.ceiba.hotelmanager.dominio.excepcion;

public class ExcepcionHabitacionInvalida extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ExcepcionHabitacionInvalida(String mensaje){
        super(mensaje);
    }
}
