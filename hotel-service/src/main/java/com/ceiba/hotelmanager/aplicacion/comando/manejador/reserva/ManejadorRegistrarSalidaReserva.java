package com.ceiba.hotelmanager.aplicacion.comando.manejador.reserva;

import com.ceiba.hotelmanager.dominio.servicio.reserva.ServicioRegistrarSalidaReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarSalidaReserva {

    private final ServicioRegistrarSalidaReserva servicioRegistrarSalidaReserva;

    public ManejadorRegistrarSalidaReserva(ServicioRegistrarSalidaReserva servicioRegistrarSalidaReserva) {
        this.servicioRegistrarSalidaReserva = servicioRegistrarSalidaReserva;
    }

    public void ejecutar(Long cedulaCiudadania){
        this.servicioRegistrarSalidaReserva.ejecutar(cedulaCiudadania);
    }
}
