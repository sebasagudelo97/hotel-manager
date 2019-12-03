package com.ceiba.hotelmanager.infraestructura.adaptador.repositorio;

import com.ceiba.hotelmanager.dominio.modelo.Habitacion;
import com.ceiba.hotelmanager.dominio.modelo.dto.HabitacionDto;
import com.ceiba.hotelmanager.dominio.puerto.repositorio.RepositorioHabitacion;
import com.ceiba.hotelmanager.infraestructura.entidad.HabitacionEntidad;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioHabitacionJpa;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioHabitacionPostgreSql implements RepositorioHabitacion {

    private ModelMapper modelMapper = new ModelMapper();
    private final RepositorioHabitacionJpa repositorioHabitacionJpa;

    public RepositorioHabitacionPostgreSql(RepositorioHabitacionJpa repositorioHabitacionJpa) {
        this.repositorioHabitacionJpa = repositorioHabitacionJpa;
    }

    @Override
    public boolean estadoHabitacion(String numeroHabitacion) {
        HabitacionEntidad habitacionEntidad = repositorioHabitacionJpa.filtroPorNumeroHabitacion(numeroHabitacion);
        return habitacionEntidad.isEstadoHabitacion();
    }

    @Override
    public Long valorHabitacion(String numeroHabitacion) {
        HabitacionEntidad habitacionEntidad = repositorioHabitacionJpa.filtroPorNumeroHabitacion(numeroHabitacion);
        return habitacionEntidad.getValorHabitacion();
    }

    @Override
    public HabitacionDto obtenerHabitacionByNumeroHabitacion(String numeroHabitacion) {
        HabitacionEntidad habitacionEntidad = repositorioHabitacionJpa.filtroPorNumeroHabitacion(numeroHabitacion);
        return modelMapper.map(habitacionEntidad, HabitacionDto.class);

    }

    @Override
    public void guardar(HabitacionDto habitacion) {
        HabitacionEntidad habitacionEntidad = modelMapper.map(habitacion,HabitacionEntidad.class );
        this.repositorioHabitacionJpa.save(habitacionEntidad);
    }
}
