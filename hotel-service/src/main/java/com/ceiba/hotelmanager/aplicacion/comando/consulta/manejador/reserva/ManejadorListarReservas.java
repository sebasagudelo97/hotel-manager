package com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.reserva;


import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservas {

    private RepositorioReserva repositorioReserva;

    public ManejadorListarReservas(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public List<Reserva> ejecutar(){
       return this.repositorioReserva.listar();
    }
}
