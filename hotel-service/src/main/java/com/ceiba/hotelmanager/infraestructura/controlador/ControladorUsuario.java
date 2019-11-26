package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.usuario.ManejadorEliminarUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.usuario.ManejadorListarUsuario;
import com.ceiba.hotelmanager.aplicacion.comando.manejador.usuario.ManejadorCrearUsuario;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    public void guardarUsuario(@RequestBody ComandoUsuario comandoUsuario){
        this.manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario(){
        return this.manejadorListarUsuario.ejecutar();
    }


    @DeleteMapping(value = "/{cedulaCiudadania}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void elimiarUsuario(@PathVariable Long cedulaCiudadania){
        this.manejadorEliminarUsuario.ejecutar(cedulaCiudadania);
    }
}