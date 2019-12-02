package com.ceiba.hotelmanager.infraestructura.convertidor.usuario;

import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.modelo.dto.UsuarioDto;
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

    public List<UsuarioDto> convertirListUsuarioEntidadAListUsuario(List<UsuarioEntidad> listUsuarioEntidad, List<UsuarioDto> listUsuario){
        for(UsuarioEntidad usuarioEntidad: listUsuarioEntidad) {
            UsuarioDto usuario= modelMapper.map(usuarioEntidad, UsuarioDto.class);
            listUsuario.add(usuario);
        }
        return listUsuario;
    }
}
