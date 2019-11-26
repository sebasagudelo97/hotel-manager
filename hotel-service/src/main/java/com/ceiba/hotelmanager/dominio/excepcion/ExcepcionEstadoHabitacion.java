package com.ceiba.hotelmanager.dominio.excepcion;

public class ExcepcionEstadoHabitacion extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionEstadoHabitacion(String mensaje){
        super(mensaje);
    }
}
