package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.usuario.ManejadorEliminarUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.usuario.ManejadorListarUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.manejador.usuario.ManejadorCrearUsuario;
import com.ceiba.hotelmanager.dominio.modelo.dto.UsuarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class ControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorListarUsuario manejadorListarUsuario;
    private final ManejadorEliminarUsuario manejadorEliminarUsuario;

    public ControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario, ManejadorListarUsuario manejadorListarUsuario, ManejadorEliminarUsuario manejadorEliminarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorListarUsuario = manejadorListarUsuario;
        this.manejadorEliminarUsuario = manejadorEliminarUsuario;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarUsuario(@RequestBody ComandoUsuario comandoUsuario){
        this.manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> listarUsuario(){
        return this.manejadorListarUsuario.ejecutar();
    }


    @DeleteMapping(value = "/{cedulaCiudadania}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void elimiarUsuario(@PathVariable Long cedulaCiudadania){
        this.manejadorEliminarUsuario.ejecutar(cedulaCiudadania);
    }
}
