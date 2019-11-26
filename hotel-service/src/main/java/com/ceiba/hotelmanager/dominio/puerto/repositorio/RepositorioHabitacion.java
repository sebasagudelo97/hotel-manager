package com.ceiba.hotelmanager.dominio.puerto.repositorio;


import com.ceiba.hotelmanager.dominio.modelo.Habitacion;

public interface RepositorioHabitacion {

    boolean estadoHabitacion(String numeroHabitacion);
    Long valorHabitacion(String numeroHabitacion);
    Habitacion obtenerHabitacionByNumeroHabitacion(String numeroHabitacion);
    void guardar(Habitacion habitacion);
}
