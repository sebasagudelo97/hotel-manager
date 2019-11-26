package com.ceiba.hotelmanager.dominio.modelo;

import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.HabitacionTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HabitacionTest {

    private static final int ID_HABITACION=1;
    private static final String NUMERO_HABITACION="201";
    private static final boolean ESTADO_HABITACION=true;
    private static final Long VALOR_HABITACION=40000L;

    @Test
    void funcionamientoGetterAndSetterHabitacion(){

        Habitacion habitacion= new HabitacionTestDataBuilder().build();
        habitacion.setIdHabitacion(ID_HABITACION);
        habitacion.setNumeroHabitacion(NUMERO_HABITACION);
        habitacion.setEstadoHabitacion(ESTADO_HABITACION);
        habitacion.setValorHabitacion(VALOR_HABITACION);

        Assertions.assertEquals(habitacion.getIdHabitacion(),ID_HABITACION);
        Assertions.assertEquals(habitacion.getNumeroHabitacion(), NUMERO_HABITACION);
        Assertions.assertEquals(habitacion.isEstadoHabitacion(),ESTADO_HABITACION);
        Assertions.assertEquals(habitacion.getValorHabitacion(),VALOR_HABITACION);
    }
}
