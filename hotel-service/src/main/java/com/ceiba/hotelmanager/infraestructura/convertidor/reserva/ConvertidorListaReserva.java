package com.ceiba.hotelmanager.infraestructura.convertidor.reserva;

import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ConvertidorListaReserva {

    private ModelMapper modelMapper = new ModelMapper();

    public List<Reserva> convertirListReservaEntidadAListReserva(List<ReservaEntidad> listReservaEntidad, List<Reserva> listReserva){
        for (ReservaEntidad reservaEntidad: listReservaEntidad){
            Reserva reserva=modelMapper.map(reservaEntidad, Reserva.class);
            listReserva.add(reserva);
        }
        return listReserva;
    }
}
