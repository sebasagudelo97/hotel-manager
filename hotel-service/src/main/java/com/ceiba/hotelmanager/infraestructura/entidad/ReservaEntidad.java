package com.ceiba.hotelmanager.infraestructura.entidad;


import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "reserva")
public class ReservaEntidad {

    private static final String ESTE_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";
    private static final String MENSAJE_VALIDAR_CORRECTO_NUMERO_PERSONAS_HABITACION="Ingreso incorrecto, en las habitaciones del segundo al cuarto piso son: (maximo 3 personas, minimo 1) y en las del quinto piso son: (maximo 8, minimo 4)";
    private static final String HABITACION_NO_EXISTENTE="La habitacion no existe. Las habitacion van del 201-210;301-310;401-410;501-510 ";
    private static final String FECHA_INVALIDA="La fecha de ingreso no puede ser mayor a la de salida";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "in_codigo")
    private int idReserva;

    @Column(name = "lon_numero_cedula", nullable = false)
    private Long numeroCedula;

    @ManyToOne()
    @JoinColumn(name = "in_codigo_usuario")
    private UsuarioEntidad usuarioEntidad;

    @Column(name = "nv_numero_habitacion", nullable = false)
    private String numeroHabitacion;

    @Column(name = "nv_cantidad_personas", nullable = false)
    private int cantidadPersonas;

    @Column(name = "date_fecha_ingreso", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaIngreso;

    @Column(name = "date_fecha_salida", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fechaSalida;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_codigo_factura" )
    private FacturaEntidad facturaEntidad;

    public ReservaEntidad(int idReserva, Long numeroCedula, UsuarioEntidad usuarioEntidad, String numeroHabitacion, int cantidadPersonas, LocalDate fechaIngreso, LocalDate fechaSalida, FacturaEntidad facturaEntidad) {
        ValidadorArgumento.validarCampoObligatorio(numeroHabitacion,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validarCampoObligatorio(cantidadPersonas,ESTE_CAMPO_DEBE_SER_OBLIGATORIO);
        ValidadorArgumento.validadorCorrecto(numeroHabitacion,cantidadPersonas,MENSAJE_VALIDAR_CORRECTO_NUMERO_PERSONAS_HABITACION);
        ValidadorArgumento.validarCorrectoIngresoHabitacion(numeroHabitacion,HABITACION_NO_EXISTENTE);
        ValidadorArgumento.validarVeracidadFecha(fechaIngreso,fechaSalida, FECHA_INVALIDA);

        this.idReserva = idReserva;
        this.numeroCedula=numeroCedula;
        this.usuarioEntidad = usuarioEntidad;
        this.numeroHabitacion = numeroHabitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.facturaEntidad = facturaEntidad;
    }

    public ReservaEntidad(){

    }
}
