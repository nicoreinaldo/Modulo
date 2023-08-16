package com.project.controllers;

import com.project.exception.InvalidParameterException;
import com.project.services.ModuloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

//Con @WebMvcTest le estamos diciendo que el que queremos testear es el Modulocontroller
//Con @ExtendWith para que sepa que va a trabajar con mokito
@ExtendWith(MockitoExtension.class)
@WebMvcTest(ModuloController.class)
class ModuloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //Para mokear el servicio, o sea simular
    @MockBean
    private ModuloService moduloService;

    //Controlamos que el get funcione con los parametros correctos
    //se utiliza mockMvc para simular una solicitud HTTP Get al endpoint
    @Test
    void getModulo() throws Exception {
        int x = 5;
        int y = 7;
        int n = 12345;
        Mockito.when(moduloService.maxMod(x,y,n)).thenReturn(12345);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/modulo")
                .param("x", String.valueOf(x))
                .param("y", String.valueOf(y))
                .param("n", String.valueOf(n))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("12345"));
    }

    //Es igual que el de arriba, pero con un parametro negativo
    @Test
    void invalidParamGetModulo() throws Exception {
        int x = -5;
        int y = 7;
        int n = 12345;
        Mockito.when(moduloService.maxMod(x,y,n))
                .thenThrow(new InvalidParameterException("no se permiten negativos"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/modulo")
                        .param("x", String.valueOf(x))
                        .param("y", String.valueOf(y))
                        .param("n", String.valueOf(n))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    //Este test en los que nos preocupamos es que los casos de test (t) sean igual que el tamaño del arreglo
    //tambien controlamos que el body sea de tipo json y que la respuesta sea una HTTP:BAD_REQUEST (400)
    @Test
    void postModuloWhitInvalidParams() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/modulo")
                        .content("{\"t\": 2, \"list\": [{\"x\": 2, \"y\": 7, \"n\": 7}]}")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    //Si llego con los tiempos hacer el test del post con status().isOK()
}