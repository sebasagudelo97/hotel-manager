package com.ceiba.hotelmanager.aplicacion.comando.fabrica;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import org.springframework.stereotype.Component;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva){
        return new Reserva(comandoReserva.getIdReserva(),comandoReserva.getNumeroCedula(),comandoReserva.getUsuario(),
                comandoReserva.getNumeroHabitacion(),comandoReserva.getCantidadPersonas(),
                comandoReserva.getFechaIngreso(),comandoReserva.getFechaSalida(),comandoReserva.getFactura());
    }
}
