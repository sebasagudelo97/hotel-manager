package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.HotelmanagerApplication;
import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;
import com.ceiba.hotelmanager.dominio.modelo.Usuario;
import com.ceiba.hotelmanager.infraestructura.adaptador.repositorio.RepositorioUsuarioImplPostgreSql;
import com.ceiba.hotelmanager.infraestructura.repositoriojpa.RepositorioUsuarioJpa;
import com.ceiba.hotelmanager.testdatabuilder.aplicacion.ComandoUsuarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelmanagerApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ControladorUsuarioTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RepositorioUsuarioJpa repositorioUsuarioJpa;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void crearUsuario() throws Exception{
        ComandoUsuario comandoUsuario = new ComandoUsuarioTestDataBuilder().build();

        mockMvc.perform(post("http://localhost:8080/usuario")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(comandoUsuario))
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listarUsuarioTest() throws Exception{
        RepositorioUsuarioImplPostgreSql repositorioUsuario = new RepositorioUsuarioImplPostgreSql(repositorioUsuarioJpa);

        Usuario primerUsuario = new Usuario(1L,1036960221L,"Juan", "Sebastian", "Agudelo", "Mejia", "3144568565");
        repositorioUsuario.guardar(primerUsuario);

        Usuario segundoUsuario = new Usuario(2L,1036960333L,"Juanes", "Sebastian", "Perez", "Mejia", "3144568566");
        repositorioUsuario.guardar(segundoUsuario);

        Usuario tercerUsuario = new Usuario(3L,1046960333L,"Maria", "Alejandra", "Agudelo", "Mejia", "3144568536");
        repositorioUsuario.guardar(tercerUsuario);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(primerUsuario);
        usuarios.add(segundoUsuario);
        usuarios.add(tercerUsuario);

        mockMvc.perform(get("http://localhost:8080/usuario")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(usuarios))).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("[0].cedulaCiudadania").value(1036960221L))
        .andExpect(jsonPath("[0].primerNombre").value("Juan"))
        .andExpect(jsonPath("[0].segundoNombre").value("Sebastian"))
        .andExpect(jsonPath("[0].primerApellido").value("Agudelo"))
        .andExpect(jsonPath("[0].segundoApellido").value("Mejia"))
        .andExpect(jsonPath("[0].numeroCelular").value("3144568565"))
                .andExpect(jsonPath("[1].cedulaCiudadania").value(1036960333L))
                .andExpect(jsonPath("[1].primerNombre").value("Juanes"))
                .andExpect(jsonPath("[1].segundoNombre").value("Sebastian"))
                .andExpect(jsonPath("[1].primerApellido").value("Perez"))
                .andExpect(jsonPath("[1].segundoApellido").value("Mejia"))
                .andExpect(jsonPath("[1].numeroCelular").value("3144568566"))
                        .andExpect(jsonPath("[2].cedulaCiudadania").value(1046960333L))
                        .andExpect(jsonPath("[2].primerNombre").value("Maria"))
                        .andExpect(jsonPath("[2].segundoNombre").value("Alejandra"))
                        .andExpect(jsonPath("[2].primerApellido").value("Agudelo"))
                        .andExpect(jsonPath("[2].segundoApellido").value("Mejia"))
                        .andExpect(jsonPath("[2].numeroCelular").value("3144568536"));

    }

    @Test
    public void eliminarUsuarioTest() throws Exception{
        RepositorioUsuarioImplPostgreSql repositorioUsuario = new RepositorioUsuarioImplPostgreSql(repositorioUsuarioJpa);

        Usuario primerUsuario = new Usuario(1L,1036960221L,"Juan", "Sebastian", "Agudelo", "Mejia", "3144568565");
        repositorioUsuario.guardar(primerUsuario);

        mockMvc.perform(delete("http://localhost:8080/usuario/1036960221")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(primerUsuario))).andDo(print()).andExpect(status().isOk());
    }
}
