package com.example.demo.unit;

import com.example.demo.domain.CalculadoraFinanciera;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculadoraFinancieraTests {

    @Test
    @DisplayName("Cálculo de cuota con sistema de amortización Francés")
    void testCalculoCuotaFrances(){
        CalculadoraFinanciera calc = new CalculadoraFinanciera();
        List<Double> result = calc.CalculoCuotasFrances((double) 10000,15,24);
        Assertions.assertEquals(484.87, result.get(0));
    }

    @Test
    @DisplayName("Cálculo de cuota con sistema de amortización Americano")
    void testCalculoCuotaAmericano(){
        CalculadoraFinanciera calc = new CalculadoraFinanciera();
        List<Double> result = calc.CalculoCuotasAmericano((double) 10000, 15, 24);
        Assertions.assertEquals(1500, result.get(0));
        Assertions.assertEquals(11500, result.get(23));
    }

    @Test
    @DisplayName("Cálculo de monto final con sistema de amortización Francés")
    void testCalculoMontoFinalFrances(){
        CalculadoraFinanciera calc = new CalculadoraFinanciera();
        Double result = calc.CalculoMontoFinalFrances((double) 10000, 15, 24);
        Assertions.assertEquals(11636.880000000001, result);
    }

    @Test
    @DisplayName("Cálculo de monto final con sistema de amortización Americano")
    void testCalculoMontoFinalAmericano(){
        CalculadoraFinanciera calc = new CalculadoraFinanciera();
        Double result = calc.CalculoMontoFinalAmericano((double) 10000, 15, 24);
        Assertions.assertEquals(46000, result);
    }
}
