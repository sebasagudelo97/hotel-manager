package com.ceiba.hotelmanager.infraestructura.convertidor.usuario;

import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.infraestructura.entidad.UsuarioEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertidorUsuario {

    private ModelMapper modelMapper = new ModelMapper();
    public UsuarioEntidad convertirUsuarioDominioAEntidad(Usuario usuario){
        return modelMapper.map(usuario, UsuarioEntidad.class);
    }

    public List<Usuario> convertirListUsuarioEntidadAListUsuario(List<UsuarioEntidad> listUsuarioEntidad, List<Usuario> listUsuario){
        for(UsuarioEntidad usuarioEntidad: listUsuarioEntidad) {
            Usuario usuario= modelMapper.map(usuarioEntidad, Usuario.class);
            listUsuario.add(usuario);
        }
        return listUsuario;
    }
}
