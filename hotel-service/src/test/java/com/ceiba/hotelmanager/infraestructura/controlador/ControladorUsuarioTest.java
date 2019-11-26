package com.ceiba.hotelmanager.infraestructura.controlador;

import com.ceiba.hotelmanager.HotelmanagerApplication;
import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

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
}
