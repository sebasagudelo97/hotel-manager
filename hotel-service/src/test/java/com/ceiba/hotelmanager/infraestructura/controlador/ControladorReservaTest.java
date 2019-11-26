package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.HotelmanagerApplication;
import com.ceiba.hotelmanager.aplicacion.comando.ComandoReserva;
import com.ceiba.hotelmanager.dominio.modelo.Habitacion;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.dominio.servicio.habitacion.ServicioCambiarEstadoHabitacion;
import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioHabitacionImpl;
import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioUsuarioImpl;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioHabitacionJpa;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioUsuarioJpa;
import com.ceiba.hotelmanager.testdatabuilder.aplicacion.ComandoReservaTestDataBuilder;;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelmanagerApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ControladorReservaTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositorioHabitacionJpa repositorioHabitacionJpa;

    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearReserva() throws Exception{
        ComandoReserva comandoReserva= new ComandoReservaTestDataBuilder().build();
        Habitacion hab = new Habitacion("201", true, 40000L);
        RepositorioHabitacionImpl repositorioHabitacion = new RepositorioHabitacionImpl(repositorioHabitacionJpa);
        repositorioHabitacion.guardar(hab);

        Usuario usuario = new Usuario(1L,1036960221L,"Juan", "Sebastian", "Agudelo", "Mejia", "3144568565");
        RepositorioUsuarioImpl repositorioUsuario = new RepositorioUsuarioImpl(repositorioUsuarioJpa);
        repositorioUsuario.guardar(usuario);


        mockMvc.perform(post("http://localhost:8080/reserva")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(comandoReserva))
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }
}
