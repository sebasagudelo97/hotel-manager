package com.ceiba.hotelmanager.infraestructura.repositoriojpa;

import com.ceiba.hotelmanager.infraestructura.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.io.Serializable;

@Repository
public interface RepositorioUsuarioJpa extends JpaRepository<UsuarioEntidad, Serializable>  {

    @Query(value = "select * from usuario  where usuario.lon_cedula_ciudadania = :cedulaUsuario", nativeQuery = true)
    UsuarioEntidad filtroPorCedulaUsuario(@Param("cedulaUsuario") Long cedulaUsuario);
}
