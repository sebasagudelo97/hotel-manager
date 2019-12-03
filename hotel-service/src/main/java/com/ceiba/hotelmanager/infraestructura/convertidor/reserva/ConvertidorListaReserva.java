package com.ceiba.hotelmanager.infraestructura.convertidor.reserva;

import com.ceiba.hotelmanager.dominio.modelo.dto.ReservaDto;
import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ConvertidorListaReserva {

    private ModelMapper modelMapper = new ModelMapper();

    public List<ReservaDto> convertirListReservaEntidadAListReserva(List<ReservaEntidad> listReservaEntidad, List<ReservaDto> listReserva){
        for (ReservaEntidad reservaEntidad: listReservaEntidad){
            ReservaDto reserva=modelMapper.map(reservaEntidad, ReservaDto.class);
            listReserva.add(reserva);
        }
        return listReserva;
    }
}
