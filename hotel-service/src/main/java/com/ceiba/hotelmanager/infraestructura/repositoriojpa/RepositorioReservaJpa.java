package com.ceiba.hotelmanager.infraestructura.repositoriojpa;


import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RepositorioReservaJpa extends JpaRepository<ReservaEntidad, Serializable> {

    @Query(value = "select * from reserva where lon_numero_cedula = :codigoUsuario", nativeQuery = true)
    ReservaEntidad filtroReservaPorNumeroCedula(@Param("codigoUsuario") Long codigoUsuario);
}
