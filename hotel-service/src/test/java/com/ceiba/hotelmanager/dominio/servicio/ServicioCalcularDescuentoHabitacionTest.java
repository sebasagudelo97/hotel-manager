package com.ceiba.hotelmanager.dominio.servicio;

import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioHabitacionImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.omg.CORBA.Any;

import java.time.LocalDate;

public class ServicioCalcularDescuentoHabitacionTest {

    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,15);
    private static final String NUMERO_HABITACION="201";
    private static final LocalDate FECHA_SALIDA_PARA_DESCUENTO=LocalDate.of(2019,5,20);
    private static final LocalDate FECHA_SALIDA_SIN_DESCUENTO=LocalDate.of(2019,5,16);

    @Test
    void calcularValorDeHabitacionConDescuentoTest(){
        RepositorioHabitacionImpl repositorioHabitacion = Mockito.mock(RepositorioHabitacionImpl.class);
        ServicioCalcularDescuentoHabitacion servicioCalcularDescuentoHabitacion=new ServicioCalcularDescuentoHabitacion(repositorioHabitacion);
        Mockito.when(repositorioHabitacion.valorHabitacion(NUMERO_HABITACION)).thenReturn(40000L);

        Long valorEsperado= 37200L;
        Long valorObtenido= servicioCalcularDescuentoHabitacion.valorHabitacion(NUMERO_HABITACION,FECHA_INGRESO,FECHA_SALIDA_PARA_DESCUENTO);

        Assertions.assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void calcularValorDeHabitacionSinDescuentoTest(){
        RepositorioHabitacionImpl repositorioHabitacion = Mockito.mock(RepositorioHabitacionImpl.class);
        ServicioCalcularDescuentoHabitacion servicioCalcularDescuentoHabitacion=new ServicioCalcularDescuentoHabitacion(repositorioHabitacion);
        Mockito.when(repositorioHabitacion.valorHabitacion(NUMERO_HABITACION)).thenReturn(40000L);

        Long valorEsperado= 40000L;
        Long valorObtenido= servicioCalcularDescuentoHabitacion.valorHabitacion(NUMERO_HABITACION,FECHA_INGRESO,FECHA_SALIDA_SIN_DESCUENTO);

        Assertions.assertEquals(valorEsperado,valorObtenido);
    }
}
