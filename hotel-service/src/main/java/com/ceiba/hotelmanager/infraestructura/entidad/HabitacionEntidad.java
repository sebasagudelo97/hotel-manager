package com.ceiba.hotelmanager.infraestructura.entidad;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
public class HabitacionEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "in_codigo")
    private int idHabitacion;

    @Column(name = "nv_numero_habitacion", nullable = false)
    private String numeroHabitacion;

    @Column(name = "nv_estado_habitacion", nullable = false)
    private boolean estadoHabitacion;

    @Column(name = "valorHabitacion", nullable = false)
    private Long valorHabitacion;
}
