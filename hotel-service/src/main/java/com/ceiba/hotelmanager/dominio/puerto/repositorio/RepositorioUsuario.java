package com.ceiba.hotelmanager.dominio.puerto.repositorio;

import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.infraestructura.entidad.UsuarioEntidad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioUsuario {

    void guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    Usuario obtenerIdUsuarioByNumeroCedula(Long numeroCedula);
    List<Usuario> listar();
    UsuarioEntidad obtenerUsuarioEntidadByNumeroCedula(Long numeroCedula);
    void eliminar(Long numeroCedula);
}