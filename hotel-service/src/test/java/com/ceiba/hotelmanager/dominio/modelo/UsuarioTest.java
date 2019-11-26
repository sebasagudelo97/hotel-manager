package com.ceiba.hotelmanager.dominio.modelo;

import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private static final Long ID_USUARIO=2L;
    private static final String PRIMER_NOMBRE="Juanito";
    private static final String SEGUNDO_NOMBRE="Sebas";
    private static final String PRIMER_APELLIDO="Agu";
    private static final String SEGUNDO_APELLIDO="Ramirez";
    private static final Long CEDULA_CIUDADANIA=10369602210L;
    private static final String NUMERO_CELULAR="31445685652";

    @Test
    void creacionUsuarioTest(){
        Usuario usuario = new UsuarioTestDataBuilder().build();
        usuario.setIdUsuario(ID_USUARIO);
        usuario.setPrimerNombre(PRIMER_NOMBRE);
        usuario.setSegundoNombre(SEGUNDO_NOMBRE);
        usuario.setPrimerApellido(PRIMER_APELLIDO);
        usuario.setSegundoApellido(SEGUNDO_APELLIDO);
        usuario.setCedulaCiudadania(CEDULA_CIUDADANIA);
        usuario.setNumeroCelular(NUMERO_CELULAR);

        Assertions.assertEquals(usuario.getIdUsuario(),ID_USUARIO);
        Assertions.assertEquals(usuario.getCedulaCiudadania(), CEDULA_CIUDADANIA);
        Assertions.assertEquals(usuario.getPrimerNombre(), PRIMER_NOMBRE);
        Assertions.assertEquals(usuario.getSegundoNombre(), SEGUNDO_NOMBRE);
        Assertions.assertEquals(usuario.getPrimerApellido(), PRIMER_APELLIDO);
        Assertions.assertEquals(usuario.getSegundoApellido(), SEGUNDO_APELLIDO);
        Assertions.assertEquals(usuario.getNumeroCelular(), NUMERO_CELULAR);
    }
}
