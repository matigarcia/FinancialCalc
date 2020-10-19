package com.example.demo.integration;

import com.example.demo.application.SimuladorPrestamoService;
import com.example.demo.controller.PrestamosController;
import com.example.demo.domain.DetallePrestamo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PrestamosControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void simularFrances() throws Exception {
        Double montoFinal = 11912.400000000001;
        Integer sizeList = 24;
        Double montoCuota = 496.35;
        List<Double> cuotas = Arrays.asList(496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35, 496.35);
        DetallePrestamo detallePrestamo = new DetallePrestamo(montoFinal, cuotas);

        mockMvc.perform(get("/prestamos/simular?monto=10000&meses=24&sistema=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.montoFinal", Matchers.is(montoFinal)))
                .andExpect(jsonPath("$.cuotas", Matchers.hasSize(sizeList)))
                .andExpect(jsonPath("$.cuotas", Matchers.hasItem(montoCuota)));
    }

    @Test
    void simularAmericano() throws Exception {
        Double montoFinal = 51760.00;
        Integer sizeList = 24;
        Double montoCuota = 1740.00;
        List<Double> cuotas = Arrays.asList(1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00, 1740.00);

        mockMvc.perform(get("/prestamos/simular?monto=10000&meses=24&sistema=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.montoFinal", Matchers.is(montoFinal)))
                .andExpect(jsonPath("$.cuotas", Matchers.hasSize(sizeList)))
                .andExpect(jsonPath("$.cuotas", Matchers.hasItem(montoCuota)));
    }
}