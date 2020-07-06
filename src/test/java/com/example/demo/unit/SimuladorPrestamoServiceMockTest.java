package com.example.demo.unit;

import com.example.demo.application.SimuladorPrestamoService;
import com.example.demo.domain.CalculadoraFinanciera;
import com.example.demo.domain.DetallePrestamo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class SimuladorPrestamoServiceMockTest {

    @Test
    void testSimularPrestamoFrances() {
        // Arrange
        CalculadoraFinanciera mockCalculadoraFinanciera = mock(CalculadoraFinanciera.class);

        Double montoFinal = 11636.880000000001;
        List<Double> cuotas = Arrays.asList(484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87, 484.87);

        when(mockCalculadoraFinanciera.CalculoCuotasFrances(10000, 17.4, 24)).thenReturn(cuotas);
        when(mockCalculadoraFinanciera.CalculoMontoFinalFrances(10000, 17.4, 24)).thenReturn(montoFinal);

        SimuladorPrestamoService simuladorPrestamoService = new SimuladorPrestamoService(mockCalculadoraFinanciera);

        // Act
        DetallePrestamo result = simuladorPrestamoService.simularPrestamo(10000, 24, 1);

        // Assert
        Assertions.assertEquals(cuotas, result.getCuotas());
        Assertions.assertEquals(montoFinal, result.getMontoFinal());

        verify(mockCalculadoraFinanciera, times(1)).CalculoCuotasFrances(10000, 17.4, 24);
        verify(mockCalculadoraFinanciera, times(1)).CalculoMontoFinalFrances(10000, 17.4, 24);
    }
}
