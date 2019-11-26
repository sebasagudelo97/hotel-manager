package com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.usuario;

import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarUsuario {

    private RepositorioUsuario repositorioUsuario;

    public ManejadorListarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> ejecutar(){
        return this.repositorioUsuario.listar();
    }
}
