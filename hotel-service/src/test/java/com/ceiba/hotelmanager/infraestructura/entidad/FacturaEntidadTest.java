package com.ceiba.hotelmanager.infraestructura.entidad;

import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.testdatabuilder.infraestructura.entidad.EntidadFacturaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FacturaEntidadTest {

    private static final int ID_FACTURA=1;
    private static final LocalDate FECHA_REGISTRO=LocalDate.of(2019,5,28);
    private static final int VALOR_PAGAR=37200;

    @Test
    void funcionamientoCorrectoGetterAndSetterFacturaTest(){
        FacturaEntidad facturaEntidad= new EntidadFacturaTestDataBuilder().build();
        facturaEntidad.setFechaRegistro(FECHA_REGISTRO);
        facturaEntidad.setValorPagar(VALOR_PAGAR);

        Assertions.assertEquals(facturaEntidad.getFechaRegistro(),FECHA_REGISTRO);
        Assertions.assertEquals(facturaEntidad.getValorPagar(),VALOR_PAGAR);
    }
}
