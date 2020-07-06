package com.example.demo.application;

import com.example.demo.domain.CalculadoraFinanciera;
import com.example.demo.domain.DetallePrestamo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimuladorPrestamoService {

    private final CalculadoraFinanciera calculadoraFinanciera;  // final = readonly de c#+
    private double TASA_12 = 13.5;
    private double TASA_1218 = 15.2;
    private double TASA_18 = 17.4;

    public SimuladorPrestamoService(CalculadoraFinanciera calculadoraFinanciera) {
        this.calculadoraFinanciera = calculadoraFinanciera;
    }

    public DetallePrestamo simularPrestamo(double monto, int meses, int tipoSistema){
        double tasa, montoFinal;
        List<Double> cuotas;
        DetallePrestamo detallePrestamo;

        if (meses <= 12){
            tasa = TASA_12;
        }
        else if (meses <= 18){
            tasa = TASA_1218;
        }
        else {
            tasa = TASA_18;
        }

        if (tipoSistema == 1){
            montoFinal = this.calculadoraFinanciera.CalculoMontoFinalFrances(monto, tasa, meses);
            cuotas = this.calculadoraFinanciera.CalculoCuotasFrances(monto, tasa, meses);
        }
        else{
            montoFinal = this.calculadoraFinanciera.CalculoMontoFinalAmericano(monto, tasa, meses);
            cuotas = this.calculadoraFinanciera.CalculoCuotasAmericano(monto, tasa, meses);
        }

        detallePrestamo = new DetallePrestamo(montoFinal, cuotas);

        return detallePrestamo;
    }


}
