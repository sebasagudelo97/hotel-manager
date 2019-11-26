package com.ceiba.hotelmanager.dominio.servicio;


import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public final class ServicioCalcularDiasHospedados {

    private ServicioCalcularDiasHospedados(){}

    public static LocalDate fechaActual(){
        return LocalDate.now();
    }

    public static Long calcularDiasHospedados(LocalDate fechaIngreso, LocalDate fechaSalida){
        Long fechaIngresoMiliSegundo = fechaIngreso.toEpochDay();
        Long fechaSalidaMiliSegndo= fechaSalida.toEpochDay();
        return fechaSalidaMiliSegndo - fechaIngresoMiliSegundo;


    }
}
