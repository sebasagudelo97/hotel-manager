package com.ceiba.hotelmanager.infraestructura.configuracion;

import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.hotelmanager.dominio.servicio.usuario.ServicioCrearUsuario;
import com.ceiba.hotelmanager.dominio.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUsuario {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario){
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario){
        return new ServicioEliminarUsuario(repositorioUsuario);
    }
}
