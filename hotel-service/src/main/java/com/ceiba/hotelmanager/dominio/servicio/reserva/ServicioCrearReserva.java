package com.ceiba.hotelmanager.dominio.servicio.reserva;

import com.ceiba.hotelmanager.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.modelo.dto.UsuarioDto;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.hotelmanager.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.hotelmanager.dominio.servicio.habitacion.ServicioCambiarEstadoHabitacion;

public class ServicioCrearReserva {

    private static final String YA_SE_ENCUENTRA_UNA_RESERVA_CON_ESTA_CEDULA="Ya se encuentra registrada una reserva con este numero de cedula";

    private RepositorioReserva repositorioReserva;
    private ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion;
    private RepositorioUsuario repositorioUsuario;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, ServicioCambiarEstadoHabitacion servicioCambiarEstadoHabitacion, RepositorioUsuario repositorioUsuario) {
        this.repositorioReserva = repositorioReserva;
        this.servicioCambiarEstadoHabitacion = servicioCambiarEstadoHabitacion;
        this.repositorioUsuario = repositorioUsuario;
    }

    private void validarExistenciaExistenciaReservaPorUsuario(Reserva reserva){
        boolean existe = this.repositorioReserva.existe(reserva);
        if (existe){
            throw new ExcepcionDuplicidad(YA_SE_ENCUENTRA_UNA_RESERVA_CON_ESTA_CEDULA);
        }
    }

    public void ejecutar(Reserva reserva) {

        UsuarioDto usuarioDto = repositorioUsuario.obtenerUsuarioByNumeroCedula(reserva.getNumeroCedula());

        validarExistenciaExistenciaReservaPorUsuario(reserva);
        servicioCambiarEstadoHabitacion.verificarDisponibilidadHabitacion(reserva.getNumeroHabitacion());
        reserva.setUsuario(usuarioDto.build());
        reserva.setFactura(ServicioCrearFactura.construirFactura(reserva));
        this.repositorioReserva.guardar(reserva);
        servicioCambiarEstadoHabitacion.cambiarEstadoHabitacion(reserva.getNumeroHabitacion());

    }
}
