package com.ceiba.hotelmanager.dominio.servicio.habitacion;

import com.ceiba.hotelmanager.dominio.excepcion.ExcepcionEstadoHabitacion;
import com.ceiba.hotelmanager.dominio.modelo.Habitacion;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioHabitacion;

public class ServicioCambiarEstadoHabitacion {

    private static final String LA_HABITACION_SE_ENCUENTRA_OCUPADA="La habitacion se encuentra ocupada";
    private final RepositorioHabitacion repositorioHabitacion;

    public ServicioCambiarEstadoHabitacion(RepositorioHabitacion repositorioHabitacion) {
        this.repositorioHabitacion = repositorioHabitacion;
    }

    public boolean consultarEstadoHabitacion(String numeroHabitacion){
        return repositorioHabitacion.estadoHabitacion(numeroHabitacion);
    }

    public void verificarDisponibilidadHabitacion(String numeroHabitacion){
        if(!consultarEstadoHabitacion(numeroHabitacion)){
            throw new ExcepcionEstadoHabitacion(LA_HABITACION_SE_ENCUENTRA_OCUPADA);
        }
    }

    public void cambiarEstadoHabitacion(String numeroHabitacion){
        Habitacion habitacion = repositorioHabitacion.obtenerHabitacionByNumeroHabitacion(numeroHabitacion);
        if (habitacion.isEstadoHabitacion()){
            habitacion.setEstadoHabitacion(false);
        }else if (!habitacion.isEstadoHabitacion()){
            habitacion.setEstadoHabitacion(true);
        }
        repositorioHabitacion.guardar(habitacion);
    }
}
