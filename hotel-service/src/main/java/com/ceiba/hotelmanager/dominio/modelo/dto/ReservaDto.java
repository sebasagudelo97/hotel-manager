package com.ceiba.hotelmanager.dominio.modelo.dto;

import java.time.LocalDate;

public class ReservaDto {

    private int idReserva;
    private Long numeroCedula;
    private UsuarioDto usuarioDto;
    private String numeroHabitacion;
    private int cantidadPersonas;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private FacturaDto facturaDto;

    public ReservaDto(){

    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Long getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Long numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public FacturaDto getFacturaDto() {
        return facturaDto;
    }

    public void setFacturaDto(FacturaDto facturaDto) {
        this.facturaDto = facturaDto;
    }
}
