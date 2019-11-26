package com.ceiba.hotelmanager.infraestructura.entidad;


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
