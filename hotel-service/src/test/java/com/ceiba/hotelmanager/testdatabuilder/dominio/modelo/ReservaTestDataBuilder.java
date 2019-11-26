package com.ceiba.hotelmanager.testdatabuilder.dominio.modelo;


import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import java.time.LocalDate;

public class ReservaTestDataBuilder {


    private static final Long NUMERO_CEDULA=1036960221L;
    private static final Usuario USUARIO= new Usuario(1l,1036960221L,"Juan","Sebastian","Agudelo", "Mejia", "3144568565");
    private static final String NUMERO_HABITACION="201";
    private static final int CANTIDAD_PERSONAS=2;
    private static final LocalDate FECHA_INGRESO= LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,20);
    private static final Factura FACTURA=new Factura(LocalDate.now(),37200);
    private static final int ID_RESERVA=1;

    private int idReserva;
    private Long numeroCedula;
    private Usuario usuario;
    private String numeroHabitacion;
    private int cantidadPersonas;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Factura factura;

    public ReservaTestDataBuilder(){
        this.idReserva=ID_RESERVA;
        this.numeroCedula=NUMERO_CEDULA;
        this.usuario=USUARIO;
        this.numeroHabitacion=NUMERO_HABITACION;
        this.cantidadPersonas=CANTIDAD_PERSONAS;
        this.fechaIngreso=FECHA_INGRESO;
        this.fechaSalida=FECHA_SALIDA;
        this.factura=FACTURA;
    }

    public ReservaTestDataBuilder conIdReserva(int id){
        this.idReserva=id;
        return this;
    }

    public ReservaTestDataBuilder conNumeroCedula(Long numeroCedula){
        this.numeroCedula=numeroCedula;
        return this;
    }

    public ReservaTestDataBuilder conUsuario(Usuario usuario){
        this.usuario=usuario;
        return  this;
    }
    public ReservaTestDataBuilder conNumeroHabitacion(String numeroHabitacion){
        this.numeroHabitacion=numeroHabitacion;
        return this;
    }

    public ReservaTestDataBuilder conCantidadPersonas(int cantidadPersonsas){
        this.cantidadPersonas=cantidadPersonsas;
        return this;
    }

    public ReservaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso=fechaIngreso;
        return this;
    }

    public ReservaTestDataBuilder conFechaSalida(LocalDate fechaSalida){
        this.fechaSalida=fechaSalida;
        return this;
    }
    public ReservaTestDataBuilder conFactura(Factura factura){
        this.factura=factura;
        return this;
    }

    public Reserva build(){
        return new Reserva(this.idReserva, this.numeroCedula, this.usuario,this.numeroHabitacion,this.cantidadPersonas,this.fechaIngreso,this.fechaSalida,this.factura);
    }
}
