package com.ceiba.hotelmanager.testdatabuilder.infraestructura.entidad;

import com.ceiba.hotelmanager.infraestructura.entidad.FacturaEntidad;
import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;
import com.ceiba.hotelmanager.infraestructura.entidad.UsuarioEntidad;
import org.mockito.Mockito;

import java.time.LocalDate;

public class EntidadReservaTestDataBuilder {

    private static final UsuarioEntidad USUARIO= Mockito.mock(UsuarioEntidad.class);
    private static final Long NUMERO_CEDULA=1036960221L;
    private static final String NUMERO_HABITACION="201";
    private static final int CANTIDAD_PERSONAS=2;
    private static final LocalDate FECHA_INGRESO= LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,20);
    private static final FacturaEntidad FACTURA=new FacturaEntidad(LocalDate.now(),37200);
    private static final int ID_RESERVA=1;

    private int idReserva;
    private Long numeroCedula;
    private UsuarioEntidad usuarioEntidad;
    private String numeroHabitacion;
    private int cantidadPersonas;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private FacturaEntidad facturaEntidad;

    public EntidadReservaTestDataBuilder(){
        this.idReserva=ID_RESERVA;
        this.numeroCedula=NUMERO_CEDULA;
        this.usuarioEntidad=USUARIO;
        this.numeroHabitacion=NUMERO_HABITACION;
        this.cantidadPersonas=CANTIDAD_PERSONAS;
        this.fechaIngreso=FECHA_INGRESO;
        this.fechaSalida=FECHA_SALIDA;
        this.facturaEntidad=FACTURA;
    }

    public EntidadReservaTestDataBuilder conIdReserva(int id){
        this.idReserva=id;
        return this;
    }

    public EntidadReservaTestDataBuilder conNumeroCedula(Long numeroCedula){
        this.numeroCedula=numeroCedula;
        return this;
    }
    public EntidadReservaTestDataBuilder conUsuario(UsuarioEntidad usuario){
        this.usuarioEntidad=usuario;
        return  this;
    }
    public EntidadReservaTestDataBuilder conNumeroHabitacion(String numeroHabitacion){
        this.numeroHabitacion=numeroHabitacion;
        return this;
    }

    public EntidadReservaTestDataBuilder conCantidadPersonas(int cantidadPersonsas){
        this.cantidadPersonas=cantidadPersonsas;
        return this;
    }

    public EntidadReservaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso=fechaIngreso;
        return this;
    }

    public EntidadReservaTestDataBuilder conFechaSalida(LocalDate fechaSalida){
        this.fechaSalida=fechaSalida;
        return this;
    }
    public EntidadReservaTestDataBuilder conFactura(FacturaEntidad factura){
        this.facturaEntidad=factura;
        return this;
    }

    public ReservaEntidad build(){
        return new ReservaEntidad(this.idReserva, this.numeroCedula, this.usuarioEntidad,this.numeroHabitacion,this.cantidadPersonas,this.fechaIngreso,this.fechaSalida,this.facturaEntidad);
    }
}
