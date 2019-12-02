package com.ceiba.hotelmanager.testdatabuilder.aplicacion;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.FacturaTestDataBuilder;
import com.ceiba.hotelmanager.testdatabuilder.dominio.modelo.UsuarioTestDataBuilder;

import java.time.LocalDate;

public class ComandoReservaTestDataBuilder {

    private static final int ID_RESERVA=1;
    private static final Long NUMERO_CEDULA=1036960221L;
    private static final Usuario USUARIO= new UsuarioTestDataBuilder().build();
    private static final String NUMERO_HABITACION="201";
    private static final int CANTIDAD_PERSONAS=2;
    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,20);
    private static final Factura FACTURA= new FacturaTestDataBuilder().build();

    private int idReserva;
    private Long numeroCedula;
    private Usuario usuario;
    private String numeroHabitacion;
    private int cantidadPersonas;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Factura factura;

    public ComandoReservaTestDataBuilder(){
        this.idReserva=ID_RESERVA;
        this.numeroCedula=NUMERO_CEDULA;
        this.usuario=USUARIO;
        this.numeroHabitacion=NUMERO_HABITACION;
        this.cantidadPersonas=CANTIDAD_PERSONAS;
        this.fechaIngreso=FECHA_INGRESO;
        this.fechaSalida=FECHA_SALIDA;
        this.factura=FACTURA;
    }

    public ComandoReservaTestDataBuilder conIdReserva(int idReserva){
        this.idReserva=idReserva;
        return this;
    }

    public ComandoReservaTestDataBuilder conNumeroCedula(Long numeroCedula){
        this.numeroHabitacion=numeroHabitacion;
        return this;
    }

    public ComandoReservaTestDataBuilder conUsuario(Usuario usuario){
        this.usuario=usuario;
        return this;
    }

    public ComandoReservaTestDataBuilder conNumeroHabitacion(String numeroHabitacion){
        this.numeroHabitacion=numeroHabitacion;
        return this;
    }

    public ComandoReservaTestDataBuilder conCantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas=cantidadPersonas;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso=fechaIngreso;
        return this;
    }

    public ComandoReservaTestDataBuilder conFechaSalida(LocalDate fechaSalida){
        this.fechaSalida=fechaSalida;
        return this;
    }

    public ComandoReservaTestDataBuilder conFactura(Factura factura){
        this.factura=factura;
        return this;
    }

    public ComandoReserva build(){
        return new ComandoReserva(this.idReserva,this.numeroCedula,this.usuario,this.numeroHabitacion,this.cantidadPersonas,this.fechaIngreso,this.fechaSalida,this.factura);
    }

}
