package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.reserva.ManejadorListarReservas;
import com.ceiba.hotelmanager.aplicacion.comando.manejador.reserva.ManejadorCrearReserva;
import com.ceiba.hotelmanager.aplicacion.comando.manejador.reserva.ManejadorRegistrarSalidaReserva;
import com.ceiba.hotelmanager.dominio.modelo.dto.ReservaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/reserva")
public class ControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private ManejadorRegistrarSalidaReserva manejadorRegistrarSalidaReserva;
    private ManejadorListarReservas manejadorListarReservas;

    public ControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorRegistrarSalidaReserva manejadorRegistrarSalidaReserva, ManejadorListarReservas manejadorListarReservas) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorRegistrarSalidaReserva=manejadorRegistrarSalidaReserva;
        this.manejadorListarReservas=manejadorListarReservas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void guardarReserva(@RequestBody ComandoReserva comandoReserva){
        this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value = "/{cedulaCiudadania}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void eliminarReserva(@PathVariable Long cedulaCiudadania){
        this.manejadorRegistrarSalidaReserva.ejecutar(cedulaCiudadania);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDto> listarReserva(){
        return this.manejadorListarReservas.ejecutar();
    }
}
