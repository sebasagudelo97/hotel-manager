package com.ceiba.hotelmanager.dominio.modelo;

import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ReservaTest {
    private static final int ID_RESERVA=2;
    private static final String NUMERO_HABITACION="203";
    private static final Long NUMERO_CEDULA=1036960221L;
    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,14);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,29);
    private static final int CANTIDAD_PERSONAS=3;
    private static final Usuario USUARIO = Mockito.mock(Usuario.class);
    private static final Factura FACTURA = Mockito.mock(Factura.class);

    @Test
    void creacionReservaTest(){
        Reserva reserva=new ReservaTestDataBuilder().build();

        reserva.setIdReserva(ID_RESERVA);
        reserva.setNumeroCedula(NUMERO_CEDULA);
        reserva.setNumeroHabitacion(NUMERO_HABITACION);
        reserva.setFechaIngreso(FECHA_INGRESO);
        reserva.setFechaSalida(FECHA_SALIDA);
        reserva.setCantidadPersonas(CANTIDAD_PERSONAS);
        reserva.setFactura(FACTURA);
        reserva.setUsuario(USUARIO);

        Assertions.assertEquals(reserva.getFactura(), FACTURA);
        Assertions.assertEquals(reserva.getUsuario(),USUARIO);
        Assertions.assertEquals(reserva.getNumeroCedula(),NUMERO_CEDULA);
        Assertions.assertEquals(reserva.getIdReserva(),ID_RESERVA);
        Assertions.assertEquals(reserva.getNumeroHabitacion(),NUMERO_HABITACION);
        Assertions.assertEquals(reserva.getCantidadPersonas(),CANTIDAD_PERSONAS);
        Assertions.assertEquals(reserva.getFechaIngreso(),FECHA_INGRESO);
        Assertions.assertEquals(reserva.getFechaSalida(),FECHA_SALIDA);
    }
}
