package com.ceiba.hotelmanager.infraestructura.entidad;

import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
public class HabitacionEntidad {
    private static final String ESTE_CAMPO_DEBE_SER_OBLIGATORIO="El campo debe de ser obligatorio";

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

