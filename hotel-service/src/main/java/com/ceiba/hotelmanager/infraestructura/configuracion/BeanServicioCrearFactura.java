package com.ceiba.hotelmanager.infraestructura.configuracion;

import com.ceiba.hotelmanager.dominio.servicio.ServicioCalcularDescuentoHabitacion;
import com.ceiba.hotelmanager.dominio.servicio.factura.ServicioCrearFactura;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCrearFactura {

    @Bean
    public ServicioCrearFactura servicioCrearFactura(ServicioCalcularDescuentoHabitacion servicioCalcularDescuentoHabitacion){
        return new ServicioCrearFactura(servicioCalcularDescuentoHabitacion);
    }
}
