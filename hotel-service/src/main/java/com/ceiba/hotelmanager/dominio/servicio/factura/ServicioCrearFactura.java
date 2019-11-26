package com.ceiba.hotelmanager.dominio.servicio.factura;

import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.servicio.ServicioCalcularDescuentoHabitacion;
import com.ceiba.hotelmanager.dominio.servicio.ServicioCalcularDiasHospedados;
import org.springframework.stereotype.Service;

@Service
public final class ServicioCrearFactura {

    private static ServicioCalcularDescuentoHabitacion servicioCalcularDescuentoHabitacion;


    private ServicioCrearFactura(ServicioCalcularDescuentoHabitacion servicioCalcularDescuentoHabitacion) {
        this.servicioCalcularDescuentoHabitacion = servicioCalcularDescuentoHabitacion;
    }


    public static Factura construirFactura(Reserva reserva){
        return new Factura(ServicioCalcularDiasHospedados.fechaActual(),Math.toIntExact(servicioCalcularDescuentoHabitacion.valorHabitacion(reserva.getNumeroHabitacion(),
                reserva.getFechaIngreso(),reserva.getFechaSalida())));
    }
}
