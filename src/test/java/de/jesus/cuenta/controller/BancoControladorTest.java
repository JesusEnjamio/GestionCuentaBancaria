package de.jesus.cuenta.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.jesus.cuenta.model.BancoCuentaAhorros;
import de.jesus.cuenta.service.BancoServicio;

@SuppressWarnings("unused")
@WebMvcTest(BancoControlador.class)
class BancoControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private BancoServicio bancoServicio;

    private final ObjectMapper mapper = new ObjectMapper();
    private BancoCuentaAhorros cuenta;

    @BeforeEach
    void setup() {
        cuenta = new BancoCuentaAhorros(15000, 4.0f);
        cuenta.consignar(2000);
    }

    @Test
    void debeResponderConDetallesDeLaCuenta() throws Exception {
        when(bancoServicio.obtenerDetalles(any())).thenReturn("Cuenta con saldo: 17000");

        mockMvc.perform(post("/banco/detalles")
                .contentType("application/json")
                .content(mapper.writeValueAsString(cuenta)))
                .andExpect(status().isOk())
                .andExpect(content().string("Cuenta con saldo: 17000"));
    }
}