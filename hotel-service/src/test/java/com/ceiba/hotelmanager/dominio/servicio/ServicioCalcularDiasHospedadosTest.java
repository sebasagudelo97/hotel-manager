package com.ceiba.hotelmanager.dominio.servicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ServicioCalcularDiasHospedadosTest {

    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,20);
    @Test
    void calcularCorrectoDiasHospedadosTest(){

        Long diasEsperados=5L;
        Long diasObtenidos=ServicioCalcularDiasHospedados.calcularDiasHospedados(FECHA_INGRESO,FECHA_SALIDA);

        Assertions.assertEquals(diasEsperados,diasObtenidos);

    }

    @Test
    void obtenerFechaActualTest(){
        LocalDate fechaActual= LocalDate.now();

        LocalDate fechaObtenida= ServicioCalcularDiasHospedados.fechaActual();

        Assertions.assertEquals(fechaActual,fechaObtenida);
    }
}
