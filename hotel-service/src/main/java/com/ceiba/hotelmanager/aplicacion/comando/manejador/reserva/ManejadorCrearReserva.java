package com.ceiba.hotelmanager.aplicacion.comando.manejador.reserva;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.aplicacion.comando.fabrica.FabricaReserva;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.servicio.reserva.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva {

    private final ServicioCrearReserva servicioCrearReserva;
    private final FabricaReserva fabricaReserva;

    public ManejadorCrearReserva(ServicioCrearReserva servicioCrearReserva, FabricaReserva fabricaReserva) {
        this.servicioCrearReserva = servicioCrearReserva;
        this.fabricaReserva = fabricaReserva;
    }

    public void ejecutar(ComandoReserva comandoReserva){
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        this.servicioCrearReserva.ejecutar(reserva);
    }
}
