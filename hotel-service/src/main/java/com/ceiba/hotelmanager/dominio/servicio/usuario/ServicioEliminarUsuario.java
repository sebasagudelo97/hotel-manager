package com.ceiba.hotelmanager.dominio.servicio.usuario;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarUsuario {

    private RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long cedulaCiudadania){
        this.repositorioUsuario.eliminar(cedulaCiudadania);
    }
}
