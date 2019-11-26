package com.ceiba.hotelmanager.dominio.servicio.reserva;

import com.ceiba.hotelmanager.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.hotelmanager.dominio.servicio.habitacion.ServicioCambiarEstadoHabitacion;
import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.ReservaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {
    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA="Ya se encuentra registrada una reserva con este numero de cedula";
    @Test
    void validarLaExistenciaDeReservaPorCedulaUsuarioTest(){
        try {
            Reserva reserva = new ReservaTestDataBuilder().build();
            RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
            ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion = Mockito.mock(ServicioCambiarEstadoHabitacion.class);
            Mockito.when(repositorioReserva.existe(Mockito.any())).thenReturn(true);
            RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
            ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva,servicioCambiarEstadoHabitacion, repositorioUsuario);

            servicioCrearReserva.ejecutar(reserva);
        }catch (ExcepcionDuplicidad e){
            Assertions.assertEquals(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA,e.getMessage());
        }
    }
}
