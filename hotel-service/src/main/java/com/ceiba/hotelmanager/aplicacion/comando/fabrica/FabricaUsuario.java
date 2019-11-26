package com.ceiba.hotelmanager.aplicacion.comando.fabrica;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario){
        return new Usuario(comandoUsuario.getIdUsuario(),comandoUsuario.getCedulaCiudadania(),comandoUsuario.getPrimerNombre()
                ,comandoUsuario.getSegundoNombre(),comandoUsuario.getPrimerApellido(),
                comandoUsuario.getSegundoApellido(),
                comandoUsuario.getNumeroCelular());
    }
}
