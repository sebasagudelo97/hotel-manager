package com.ceiba.hotelmanager.infraestructura.repositoriojpa;

import com.ceiba.hotelmanager.infraestructura.entidad.HabitacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RepositorioHabitacionJpa extends JpaRepository<HabitacionEntidad, Serializable>{

    @Query("select e from HabitacionEntidad e where e.numeroHabitacion = :numeroHabitacion" )
    HabitacionEntidad filtroPorNumeroHabitacion(@Param("numeroHabitacion") String numeroHabitacion);
}
