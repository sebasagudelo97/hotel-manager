package com.ceiba.hotelmanager.infraestructura.error;

import com.ceiba.hotelmanager.dominio.excepcion.ExcepcionObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManejadorErrorTest {
    private static final String DATO_OBLIGATORIO="Este Campo debe de ser obligatorio";
    @Test
    void instanciaCorrecta() {
        ManejadorError manejadorError = new ManejadorError();
        Assertions.assertNotNull(manejadorError);
    }
    @Test
    void handleAllExceptionCorrecta() {
        ManejadorError manejadorError = new ManejadorError();
        ExcepcionObligatorio excepcionObligatorio = new ExcepcionObligatorio(DATO_OBLIGATORIO);
        Assertions.assertTrue(manejadorError.handleAllException(excepcionObligatorio).hasBody());
    }
    @Test
    void handleAllExceptionIncorrecta() {
        ManejadorError manejadorError = new ManejadorError();
        Assertions.assertTrue(manejadorError.handleAllException(new Exception()).hasBody());
    }
}
