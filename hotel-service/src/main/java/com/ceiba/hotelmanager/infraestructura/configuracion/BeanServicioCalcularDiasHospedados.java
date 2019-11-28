package com.ceiba.hotelmanager.infraestructura.configuracion;

import com.ceiba.hotelmanager.dominio.servicio.ServicioCalcularDiasHospedados;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCalcularDiasHospedados {

    public ServicioCalcularDiasHospedados servicioCalcularDiasHospedados(){
        return new ServicioCalcularDiasHospedados();
    }
}
