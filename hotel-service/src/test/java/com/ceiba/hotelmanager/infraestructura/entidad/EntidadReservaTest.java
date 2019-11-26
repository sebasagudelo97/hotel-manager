package com.ceiba.hotelmanager.infraestructura.entidad;

import com.ceiba.hotelmanager.testdatabuilder.infraestructura.entidad.EntidadReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class EntidadReservaTest {

    private static final UsuarioEntidad USUARIO= Mockito.mock(UsuarioEntidad.class);
    private static final String NUMERO_HABITACION="201";
    private static final Long NUMERO_CEDULA=1036960221L;
    private static final int CANTIDAD_PERSONAS=2;
    private static final LocalDate FECHA_INGRESO= LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,20);
    private static final FacturaEntidad FACTURA=Mockito.mock(FacturaEntidad.class);
    private static final int ID_RESERVA=1;

    @Test
    void funcionamientoGetReservaEntidadTest(){

        ReservaEntidad reservaEntidad = new EntidadReservaTestDataBuilder().build();

        reservaEntidad.setUsuarioEntidad(USUARIO);
        reservaEntidad.setNumeroHabitacion(NUMERO_HABITACION);
        reservaEntidad.setNumeroCedula(NUMERO_CEDULA);
        reservaEntidad.setCantidadPersonas(CANTIDAD_PERSONAS);
        reservaEntidad.setFacturaEntidad(FACTURA);
        reservaEntidad.setFechaIngreso(FECHA_INGRESO);
        reservaEntidad.setFechaSalida(FECHA_SALIDA);
        reservaEntidad.setFacturaEntidad(FACTURA);
        reservaEntidad.setIdReserva(ID_RESERVA);

        Assertions.assertEquals(reservaEntidad.getNumeroHabitacion(),NUMERO_HABITACION);
        Assertions.assertEquals(reservaEntidad.getCantidadPersonas(),CANTIDAD_PERSONAS);
        Assertions.assertEquals(reservaEntidad.getFechaIngreso(),FECHA_INGRESO);
        Assertions.assertEquals(reservaEntidad.getFechaSalida(),FECHA_SALIDA);
        Assertions.assertEquals(reservaEntidad.getIdReserva(),ID_RESERVA);
        Assertions.assertEquals(reservaEntidad.getUsuarioEntidad(),USUARIO);
        Assertions.assertEquals(reservaEntidad.getFacturaEntidad(),FACTURA);
        Assertions.assertEquals(reservaEntidad.getNumeroCedula(),NUMERO_CEDULA);
    }
}
