package com.ceiba.hotelmanager.infraestructura.entidad;

import com.ceiba.hotelmanager.testdatabuilder.infraestructura.entidad.EntidadUsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntidadUsuarioTest {
    private static final String PRIMER_NOMBRE="Juan";
    private static final String SEGUNDO_NOMBRE="Sebastian";
    private static final String PRIMER_APELLIDO="Agudelo";
    private static final String SEGUNDO_APELLIDO="Mejia";
    private static final Long CEDULA_CIUDADANIA=1036960221L;
    private static final String NUMERO_CELULAR="3144568565";

    @Test
    void funcionamientoGetUsuarioEntidadTest(){
        UsuarioEntidad usuarioEntidad = new EntidadUsuarioTestDataBuilder().build();

        usuarioEntidad.setPrimerNombre(PRIMER_NOMBRE);
        usuarioEntidad.setSegundoNombre(SEGUNDO_NOMBRE);
        usuarioEntidad.setPrimerApellido(PRIMER_APELLIDO);
        usuarioEntidad.setSegundoApellido(SEGUNDO_APELLIDO);
        usuarioEntidad.setNumeroCelular(NUMERO_CELULAR);
        usuarioEntidad.setCedulaCiudadania(CEDULA_CIUDADANIA);

        Assertions.assertEquals(usuarioEntidad.getCedulaCiudadania(),CEDULA_CIUDADANIA);
        Assertions.assertEquals(usuarioEntidad.getPrimerNombre(),PRIMER_NOMBRE);
        Assertions.assertEquals(usuarioEntidad.getSegundoNombre(),SEGUNDO_NOMBRE);
        Assertions.assertEquals(usuarioEntidad.getPrimerApellido(),PRIMER_APELLIDO);
        Assertions.assertEquals(usuarioEntidad.getSegundoApellido(),SEGUNDO_APELLIDO);
        Assertions.assertEquals(usuarioEntidad.getNumeroCelular(),NUMERO_CELULAR);
    }
}
