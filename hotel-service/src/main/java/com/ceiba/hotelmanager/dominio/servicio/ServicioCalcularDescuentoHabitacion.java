package com.ceiba.hotelmanager.dominio.servicio;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioHabitacionImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


public class ServicioCalcularDescuentoHabitacion {

    private static final int DIAS_MINIMOS_PARA_DESCUENTO_DE_HABITACION=4;
    private static final Long PORCENTAJE_DE_DESCUENTO_HABITACION=7L;
    private static final Long DIVISOR_OPERACION_PORCENTAJE=100L;

    private final RepositorioHabitacion repositorioHabitacion;

    public ServicioCalcularDescuentoHabitacion(RepositorioHabitacion repositorioHabitacion){
        this.repositorioHabitacion=repositorioHabitacion;
    }

    public Long valorHabitacion(String numeroHabitacion, LocalDate fechaIngreso, LocalDate fechaSalida){
        Long valor=repositorioHabitacion.valorHabitacion(numeroHabitacion);

        if (ServicioCalcularDiasHospedados.calcularDiasHospedados(fechaIngreso,fechaSalida) > DIAS_MINIMOS_PARA_DESCUENTO_DE_HABITACION){
            Long descuento = (PORCENTAJE_DE_DESCUENTO_HABITACION * valor) / DIVISOR_OPERACION_PORCENTAJE;
            valor = valor - descuento;
        }

        return valor;
    }
}
