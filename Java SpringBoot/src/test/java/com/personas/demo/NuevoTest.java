package com.personas.demo;

import com.personas.demo.models.Persona;
import com.personas.demo.repository.Repositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class NuevoTest {

    @Autowired
    private MockMvc mock;

    @MockBean
    private Repositorio repositorio;

    @Test
    public void ok() throws Exception{
        Mockito.when(repositorio.findAll()).thenReturn(new ArrayList<Persona>());
            this.mock.perform(MockMvcRequestBuilders.get("/api/control/empleados").contentType("application/json"));
    }

}
