package com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.usuario;

import com.ceiba.hotelmanager.dominio.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarUsuario {
    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long cedulaCiudadania){
        this.servicioEliminarUsuario.ejecutar(cedulaCiudadania);
    }
}
