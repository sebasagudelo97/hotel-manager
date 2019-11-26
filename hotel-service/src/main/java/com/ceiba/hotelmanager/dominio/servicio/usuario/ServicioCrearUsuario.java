package com.ceiba.hotelmanager.dominio.servicio.usuario;

import com.ceiba.hotelmanager.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioCrearUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA="El usuario ya se encuentra registrado en el sistema";
    private RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario){
        this.repositorioUsuario=repositorioUsuario;
    }

    private void validarExistencia(Usuario usuario){
        boolean existe = this.repositorioUsuario.existe(usuario);
        if (existe){
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void ejecutar(Usuario usuario){
        validarExistencia(usuario);
        this.repositorioUsuario.guardar(usuario);
    }
}
