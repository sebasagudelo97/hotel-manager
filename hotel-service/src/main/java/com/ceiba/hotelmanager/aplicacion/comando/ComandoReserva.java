package com.ceiba.hotelmanager.aplicacion.comando;

import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;


import java.time.LocalDate;


public class ComandoReserva {

    private int idReserva;
    private Long numeroCedula;
    private Usuario usuario;
    private String numeroHabitacion;
    private int cantidadPersonas;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Factura factura;

    public ComandoReserva(int idReserva, Long numeroCedula, Usuario usuario, String numeroHabitacion, int cantidadPersonas, LocalDate fechaIngreso, LocalDate fechaSalida, Factura factura) {
        this.idReserva = idReserva;
        this.numeroCedula=numeroCedula;
        this.usuario = usuario;
        this.numeroHabitacion = numeroHabitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.factura = factura;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Long getNumeroCedula() {
        return numeroCedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public Factura getFactura() {
        return factura;
    }
}
