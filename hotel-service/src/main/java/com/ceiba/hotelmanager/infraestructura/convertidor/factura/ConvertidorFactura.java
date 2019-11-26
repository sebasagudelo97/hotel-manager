package com.ceiba.hotelmanager.infraestructura.convertidor.factura;

import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.infraestructura.entidad.FacturaEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertidorFactura {

    private ModelMapper modelMapper = new ModelMapper();
    public FacturaEntidad convertirFacturaDominioAEntidad(Factura factura){
        return modelMapper.map(factura,FacturaEntidad.class);

    }
}
