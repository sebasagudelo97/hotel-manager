package com.ceiba.hotelmanager.dominio.excepcion;

public class ExcepcionPersonasSegunElPiso extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionPersonasSegunElPiso(String mensaje){
        super(mensaje);
    }
}
