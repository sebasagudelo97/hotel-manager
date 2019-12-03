package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.HotelmanagerApplication;
import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.dominio.modelo.Factura;
import com.ceiba.hotelmanager.dominio.modelo.Reserva;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.modelo.dto.HabitacionDto;
import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioHabitacionPostgreSql;
import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioUsuarioImplPostgreSql;
import com.ceiba.hotelmanager.infraestructura.convertidor.factura.ConvertidorFactura;
import com.ceiba.hotelmanager.infraestructura.convertidor.usuario.ConvertidorUsuario;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioHabitacionJpa;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioReservaJpa;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioUsuarioJpa;
import com.ceiba.hotelmanager.testdatabuilder.aplicacion.ComandoReservaTestDataBuilder;;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelmanagerApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ControladorReservaTest {
    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,20);
    private static final LocalDate FECHA_REGISTRO=LocalDate.now();

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ConvertidorUsuario convertidorUsuario;

    @Autowired
    private ConvertidorFactura convertidorFactura;

    @Autowired
    private RepositorioHabitacionJpa repositorioHabitacionJpa;

    @Autowired
    private RepositorioReservaJpa repositorioReservaJpa;

    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearReserva() throws Exception{
        ComandoReserva comandoReserva= new ComandoReservaTestDataBuilder().build();
        HabitacionDto hab = new HabitacionDto("201", true, 40000L);
        RepositorioHabitacionPostgreSql repositorioHabitacion = new RepositorioHabitacionPostgreSql(repositorioHabitacionJpa);
        repositorioHabitacion.guardar(hab);

        Usuario usuario = new Usuario(1L,1036960221L,"Juan", "Sebastian", "Agudelo", "Mejia", "3144568565");
        RepositorioUsuarioImplPostgreSql repositorioUsuario = new RepositorioUsuarioImplPostgreSql(repositorioUsuarioJpa);
        repositorioUsuario.guardar(usuario);


        mockMvc.perform(post("http://localhost:8080/reserva")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(comandoReserva))
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listarReservasTest() throws Exception{
        RepositorioHabitacionPostgreSql repositorioHabitacion = new RepositorioHabitacionPostgreSql(repositorioHabitacionJpa);
        RepositorioUsuarioImplPostgreSql repositorioUsuario = new RepositorioUsuarioImplPostgreSql(repositorioUsuarioJpa);

        HabitacionDto primeraHabitacion = new HabitacionDto("201", true, 40000L);
        repositorioHabitacion.guardar(primeraHabitacion);
        HabitacionDto segundaHabitacion = new HabitacionDto("202", true, 40000L);
        repositorioHabitacion.guardar(segundaHabitacion);

        Usuario primerUsuario = new Usuario(1L,1036960221L,"Juan", "Sebastian", "Agudelo", "Mejia", "3144568565");
        repositorioUsuario.guardar(primerUsuario);
        Usuario segundoUsuario = new Usuario(2L,1036960222L,"Juanes", "Esteban", "Agudelo", "Mejia", "3144668565");
        repositorioUsuario.guardar(segundoUsuario);

        Factura primeraFactura = new Factura(FECHA_REGISTRO,37200);
        Factura segundaFactura = new Factura(FECHA_REGISTRO,37200);


        Reserva primeraReserva= new Reserva(1,1036960221L,primerUsuario,"201",2, FECHA_INGRESO,FECHA_SALIDA,primeraFactura);
        Reserva segumdaReserva= new Reserva(2,1036960222L,primerUsuario,"202",2, FECHA_INGRESO,FECHA_SALIDA,segundaFactura);

        ArrayList<Reserva> reservas = new ArrayList<>();
        reservas.add(primeraReserva);
        reservas.add(segumdaReserva);

        mockMvc.perform(get("http://localhost:8080/reserva")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(reservas))).andDo(print()).andExpect(status().isOk());
    }

}
