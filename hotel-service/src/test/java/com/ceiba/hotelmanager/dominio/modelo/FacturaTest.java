package com.ceiba.hotelmanager.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FacturaTest {

    private static final LocalDate FECHA_REGISTRO=LocalDate.of(2019,5,28);
    private static final int VALOR_PAGAR=37200;

    @Test
    void funcionamientoGetterAndSetterDeFacturaTest(){

        Factura factura = new Factura(LocalDate.now(),40000);
        factura.setFechaRegistro(FECHA_REGISTRO);
        factura.setValorPagar(VALOR_PAGAR);

        Assertions.assertEquals(factura.getFechaRegistro(),FECHA_REGISTRO);
        Assertions.assertEquals(factura.getValorPagar(),VALOR_PAGAR);
    }
}
