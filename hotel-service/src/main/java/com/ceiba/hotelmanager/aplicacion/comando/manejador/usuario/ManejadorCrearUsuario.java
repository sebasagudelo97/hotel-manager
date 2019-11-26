package com.ceiba.hotelmanager.aplicacion.comando.manejador.usuario;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.fabrica.FabricaUsuario;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.servicio.usuario.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearUsuario {

    private final ServicioCrearUsuario servicioCrearUsuario;
    private final FabricaUsuario fabricaUsuario;

    public ManejadorCrearUsuario(ServicioCrearUsuario servicioCrearUsuario, FabricaUsuario fabricaUsuario) {
        this.servicioCrearUsuario = servicioCrearUsuario;
        this.fabricaUsuario = fabricaUsuario;
    }

    public void ejecutar(ComandoUsuario comandoUsuario){
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        this.servicioCrearUsuario.ejecutar(usuario);
    }
}
