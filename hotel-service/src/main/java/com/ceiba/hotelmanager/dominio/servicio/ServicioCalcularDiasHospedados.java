package com.ceiba.hotelmanager.dominio.servicio;
import java.time.LocalDate;


public class ServicioCalcularDiasHospedados {

    public ServicioCalcularDiasHospedados(){}

    public static LocalDate fechaActual(){
        return LocalDate.now();
    }

    public static Long calcularDiasHospedados(LocalDate fechaIngreso, LocalDate fechaSalida){
        Long fechaIngresoMiliSegundo = fechaIngreso.toEpochDay();
        Long fechaSalidaMiliSegndo= fechaSalida.toEpochDay();
        return fechaSalidaMiliSegndo - fechaIngresoMiliSegundo;


    }
}
