package com.ceiba.hotelmanager.infraestructura.configuracion;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.hotelmanager.dominio.servicio.habitacion.ServicioCambiarEstadoHabitacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioHabitacion {

    @Bean
    public ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion(RepositorioHabitacion repositorioHabitacion){
        return new ServicioCambiarEstadoHabitacion(repositorioHabitacion);
    }
}
