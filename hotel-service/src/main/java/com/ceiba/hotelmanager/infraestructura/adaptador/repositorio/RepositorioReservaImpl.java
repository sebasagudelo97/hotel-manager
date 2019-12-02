package com.ceiba.hotelmanager.infraestructura.adaptador.repositorio;


import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.modelo.dto.ReservaDto;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioReserva;
import com.ceiba.hotelmanager.infraestructura.convertidor.factura.ConvertidorFactura;
import com.ceiba.hotelmanager.infraestructura.convertidor.reserva.ConvertidorListaReserva;
import com.ceiba.hotelmanager.infraestructura.convertidor.usuario.ConvertidorUsuario;
import com.ceiba.hotelmanager.infraestructura.entidad.ReservaEntidad;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioReservaJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioReservaImpl implements RepositorioReserva {

    private ModelMapper modelMapper=new ModelMapper();
    private ConvertidorListaReserva convertidorListaReserva=new ConvertidorListaReserva();
    private RepositorioReservaJpa repositorioReservaJpa;
    ConvertidorUsuario convertidorUsuario = new ConvertidorUsuario();
    ConvertidorFactura convertidorFactura = new ConvertidorFactura();

    public RepositorioReservaImpl(RepositorioReservaJpa repositorioReservaJpa) {
        this.repositorioReservaJpa = repositorioReservaJpa;
    }

    @Override
    public void guardar(Reserva reserva) {
        ReservaEntidad reservaEntidad=modelMapper.map(reserva, ReservaEntidad.class);
        reservaEntidad.setUsuarioEntidad(convertidorUsuario.convertirUsuarioDominioAEntidad(reserva.getUsuario()));
        reservaEntidad.setFacturaEntidad(convertidorFactura.convertirFacturaDominioAEntidad(reserva.getFactura()));
        repositorioReservaJpa.save(reservaEntidad);
    }

    @Override
    public void salida(Long cedulaCiudadania) {
        ReservaEntidad reservaEntidad = repositorioReservaJpa.filtroReservaPorNumeroCedula(cedulaCiudadania);
        repositorioReservaJpa.delete(reservaEntidad);
    }

    @Override
    public boolean existe(Reserva reserva) {
        Long celudaExistente=reserva.getNumeroCedula();
        return repositorioReservaJpa.filtroReservaPorNumeroCedula(celudaExistente) != null;
    }

    @Override
    public ReservaEntidad obtenerReservaByNumeroCedula(Long numeroCedula) {
        return repositorioReservaJpa.filtroReservaPorNumeroCedula(numeroCedula);
    }

    public List<ReservaDto> listar() {
        List<ReservaEntidad> listReservaEntidad = repositorioReservaJpa.findAll();
        List<ReservaDto> listReserva=new ArrayList<>();
        return convertidorListaReserva.convertirListReservaEntidadAListReserva(listReservaEntidad,listReserva);
    }
}
