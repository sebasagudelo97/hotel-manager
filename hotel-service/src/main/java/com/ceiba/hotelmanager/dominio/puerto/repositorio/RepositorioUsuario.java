package com.ceiba.hotelmanager.dominio.puerto.repositorio;

import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.modelo.dto.UsuarioDto;
import com.ceiba.hotelmanager.infraestructura.entidad.UsuarioEntidad;

import java.util.List;

public interface RepositorioUsuario {

    void guardar(Usuario usuario);
    boolean existe(Usuario usuario);
    UsuarioDto obtenerUsuarioByNumeroCedula(Long numeroCedula);
    List<UsuarioDto> listar();
    UsuarioEntidad obtenerUsuarioEntidadByNumeroCedula(Long numeroCedula);
    void eliminar(Long numeroCedula);
}