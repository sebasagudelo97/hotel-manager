package com.ceiba.hotelmanager.infraestructura.configuracion;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.hotelmanager.dominio.servicio.habitacion.ServicioCambiarEstadoHabitacion;
import com.ceiba.hotelmanager.dominio.servicio.reserva.ServicioCrearReserva;
import com.ceiba.hotelmanager.dominio.servicio.reserva.ServicioRegistrarSalidaReserva;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioReserva<ServicioRegistrarSalidaHabitacion> {

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion, RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearReserva(repositorioReserva, servicioCambiarEstadoHabitacion, repositorioUsuario);
    }

    @Bean
    public ServicioRegistrarSalidaReserva servicioRegistrarSalidaReserva(RepositorioReserva repositorioReserva, ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion){
        return new ServicioRegistrarSalidaReserva(repositorioReserva,servicioCambiarEstadoHabitacion);
    }
}
