package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.aplicacion.comando.consulta.manejador.reserva.ManejadorListarReservas;
import com.ceiba.hotelmanager.aplicacion.comando.manejador.reserva.ManejadorCrearReserva;
import com.ceiba.hotelmanager.aplicacion.comando.manejador.reserva.ManejadorRegistrarSalidaReserva;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    public void guardarReserva(@RequestBody ComandoReserva comandoReserva){
        this.manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value = "/{cedulaCiudadania}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarReserva(@PathVariable Long cedulaCiudadania){
        this.manejadorRegistrarSalidaReserva.ejecutar(cedulaCiudadania);
    }

    @GetMapping
    public List<Reserva> listarReserva(){
        return this.manejadorListarReservas.ejecutar();
    }
}
