package com.ceiba.hotelmanager.dominio.servicio.usuario;

import com.ceiba.hotelmanager.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearUsuarioTest {
    private static final String EL_USUARIO_YA_EXISTE="El usuario ya se encuentra registrado en el sistema";


    @Test
    void validarExistenciaDeUsuarioTest(){
       try {
           Usuario usuario = new UsuarioTestDataBuilder().build();
           RepositorioUsuario repositorioUsuario= Mockito.mock(RepositorioUsuario.class);
           Mockito.when(repositorioUsuario.existe(Mockito.any())).thenReturn(true);
           ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);

           servicioCrearUsuario.ejecutar(usuario);
       }catch (ExcepcionDuplicidad e){
           Assertions.assertEquals(EL_USUARIO_YA_EXISTE, e.getMessage());
       }
    }

}
