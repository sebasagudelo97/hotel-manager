package com.ceiba.hotelmanager.infraestructura.configuracion;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.hotelmanager.dominio.servicio.ServicioCalcularDescuentoHabitacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCalcularDescuentoHabitacion {

    @Bean
    public ServicioCalcularDescuentoHabitacion servicioCalcularDescuentoHabitacion(RepositorioHabitacion repositorioHabitacion){
        return new ServicioCalcularDescuentoHabitacion(repositorioHabitacion);
    }
}
