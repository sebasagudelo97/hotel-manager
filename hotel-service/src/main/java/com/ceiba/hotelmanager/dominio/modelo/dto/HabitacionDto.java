package com.ceiba.hotelmanager.dominio.modelo.dto;

public class HabitacionDto {

    private int idHabitacion;
    private String numeroHabitacion;
    private boolean estadoHabitacion;
    private Long valorHabitacion;

    public HabitacionDto(){

    }

    public HabitacionDto(String numeroHabitacion, boolean estadoHabitacion, Long valorHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.valorHabitacion = valorHabitacion;
    }

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
