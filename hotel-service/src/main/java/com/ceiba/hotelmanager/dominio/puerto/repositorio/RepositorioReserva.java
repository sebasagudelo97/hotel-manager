package com.ceiba.hotelmanager.dominio.puerto.repositorio;

import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.modelo.dto.ReservaDto;
import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;

import java.util.List;


public interface RepositorioReserva {
    void guardar(Reserva reserva);
    void salida(Long cedulaCiudadania);
    boolean existe(Reserva reserva);
    ReservaEntidad obtenerReservaByNumeroCedula(Long numeroCedula);
    List<ReservaDto> listar();
}


