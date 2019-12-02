package com.ceiba.hotelmanager.dominio.modelo;

import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;

import java.time.LocalDate;


public class Reserva {

    private static final String ESTE_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";
    private static final String MENSAJE_VALIDAR_CORRECTO_NUMERO_PERSONAS_HABITACION="Ingreso incorrecto, en las habitaciones del segundo al cuarto piso son: (maximo 3 personas, minimo 1) y en las del quinto piso son: (maximo 8, minimo 4)";
    private static final String HABITACION_NO_EXISTENTE="La habitacion no existe. Las habitacion van del 201-210;301-310;401-410;501-510 ";
    private static final String FECHA_INVALIDA="La fecha de ingreso no puede ser mayor a la de salida";

    private int idReserva;
    private Long numeroCedula;
    private Usuario usuario;
    private String numeroHabitacion;
    private int cantidadPersonas;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Factura factura;

    public Reserva(int idReserva, Long numeroCedula, Usuario usuario, String numeroHabitacion, int cantidadPersonas, LocalDate fechaIngreso, LocalDate fechaSalida, Factura factura) {
        ValidadorArgumento.validarCampoObligatorio(numeroHabitacion,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(cantidadPersonas,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validadorCorrecto(numeroHabitacion,cantidadPersonas,MENSAJE_VALIDAR_CORRECTO_NUMERO_PERSONAS_HABITACION);
        ValidadorArgumento.validarCorrectoIngresoHabitacion(numeroHabitacion,HABITACION_NO_EXISTENTE);
        ValidadorArgumento.validarVeracidadFecha(fechaIngreso,fechaSalida, FECHA_INVALIDA);

        this.idReserva = idReserva;
        this.usuario = usuario;
        this.numeroCedula=numeroCedula;
        this.numeroHabitacion = numeroHabitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.factura = factura;
    }

    public Reserva ()
    {}

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Long getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(Long numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

}
