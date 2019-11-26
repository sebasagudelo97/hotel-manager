package com.ceiba.hotelmanager.testdatabuilder.dominio.modelo;

import com.ceiba.hotelmanager.dominio.modelo.Habitacion;

public class HabitacionTestDataBuilder {

    private static final int ID_HABITACION=1;
    private static final String NUMERO_HABITACION="201";
    private static final boolean ESTADO_HABITACION=true;
    private static final Long VALOR_HABITACION=40000L;

    private int idHabitacion;
    private String numeroHabitacion;
    private boolean estadoHabitacion;
    private Long valorHabitacion;

    public HabitacionTestDataBuilder(){
        this.idHabitacion=ID_HABITACION;
        this.numeroHabitacion=NUMERO_HABITACION;
        this.estadoHabitacion=ESTADO_HABITACION;
        this.valorHabitacion=VALOR_HABITACION;
    }

    public HabitacionTestDataBuilder conIdHabitacion(int idHabitacion){
        this.idHabitacion=idHabitacion;
        return this;
    }

    public HabitacionTestDataBuilder conNumeroHabitacion(String numeroHabitacion){
        this.numeroHabitacion=numeroHabitacion;
        return this;
    }

    public HabitacionTestDataBuilder conEstadoHabitacion(boolean estadoHabitacion){
        this.estadoHabitacion=estadoHabitacion;
        return this;
    }

    public HabitacionTestDataBuilder conValorHabitacion(Long valorHabitacion){
        this.valorHabitacion=valorHabitacion;
        return this;
    }

    public Habitacion build(){
        return new Habitacion(this.numeroHabitacion,this.estadoHabitacion, this.valorHabitacion);
    }
}
