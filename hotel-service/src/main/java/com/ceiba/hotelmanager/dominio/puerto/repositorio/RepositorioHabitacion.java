package com.ceiba.hotelmanager.dominio.puerto.repositorio;
import com.ceiba.hotelmanager.dominio.modelo.dto.HabitacionDto;

public interface RepositorioHabitacion {

    boolean estadoHabitacion(String numeroHabitacion);
    Long valorHabitacion(String numeroHabitacion);
    HabitacionDto obtenerHabitacionByNumeroHabitacion(String numeroHabitacion);
    void guardar(HabitacionDto habitacion);
}
