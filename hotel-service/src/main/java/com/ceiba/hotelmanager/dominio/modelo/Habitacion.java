package com.ceiba.hotelmanager.dominio.modelo;


import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;

public class Habitacion {
    private static final String ESTE_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";

    private int idHabitacion;
    private String numeroHabitacion;
    private boolean estadoHabitacion;
    private Long valorHabitacion;

    public Habitacion(String numeroHabitacion, boolean estadoHabitacion, Long valorHabitacion){
        ValidadorArgumento.validarCampoObligatorio(numeroHabitacion,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(estadoHabitacion,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(valorHabitacion,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);

        this.numeroHabitacion= numeroHabitacion;
        this.estadoHabitacion=estadoHabitacion;
        this.valorHabitacion=valorHabitacion;
    }

    public Habitacion(){}

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public boolean isEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(boolean estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public Long getValorHabitacion() {
        return valorHabitacion;
    }

    public void setValorHabitacion(Long valorHabitacion) {
        this.valorHabitacion = valorHabitacion;
    }
}
