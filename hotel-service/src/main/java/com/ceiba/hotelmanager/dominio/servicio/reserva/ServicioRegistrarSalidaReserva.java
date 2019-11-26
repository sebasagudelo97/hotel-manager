package com.ceiba.hotelmanager.dominio.servicio.reserva;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.hotelmanager.dominio.servicio.habitacion.ServicioCambiarEstadoHabitacion;
import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;
import org.springframework.stereotype.Service;

@Service
public class ServicioRegistrarSalidaReserva {
    private RepositorioReserva repositorioReserva;
    private ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion;

    public ServicioRegistrarSalidaReserva(RepositorioReserva repositorioReserva, ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion) {
        this.repositorioReserva = repositorioReserva;
        this.servicioCambiarEstadoHabitacion=servicioCambiarEstadoHabitacion;
    }

    public void ejecutar(Long cedulaCiudadania){
        ReservaEntidad reservaEntidad=repositorioReserva.obtenerReservaByNumeroCedula(cedulaCiudadania);
        servicioCambiarEstadoHabitacion.cambiarEstadoHabitacion(reservaEntidad.getNumeroHabitacion());
        this.repositorioReserva.salida(cedulaCiudadania);

    }

}
