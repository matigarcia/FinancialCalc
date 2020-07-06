package com.example.demo.domain;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalculadoraFinanciera {

    public Double CalculoMontoFinalFrances(double monto, double tasa, int meses){
        List<Double> cuotas = CalculoCuotasFrances(monto, tasa, meses);
        return cuotas.stream().mapToDouble(f -> f).sum();
    }

    public Double CalculoMontoFinalAmericano(double monto, double tasa, int meses){
        List<Double> cuotas = CalculoCuotasAmericano(monto, tasa, meses);
        return cuotas.stream().mapToDouble(f -> f).sum();
    }

    public List<Double> CalculoCuotasFrances(double monto, double tasa, int meses){
        List<Double> cuotas = new ArrayList<Double>();
        double monthlyInterestRate = tasa / 1200;
        double loanAmount = monto;
        double numberOfMonths = meses;
        double monthlyPayment = loanAmount * monthlyInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfMonths));

        DecimalFormat df = new DecimalFormat("#.##");
        monthlyPayment = Double.parseDouble(df.format(monthlyPayment));

        for (int i = 1; i <= meses; i++) {
            cuotas.add(monthlyPayment);
        }

        return cuotas;
    }

    public List<Double> CalculoCuotasAmericano(double monto, double tasa, int meses){
        List<Double> cuotas = new ArrayList<Double>();
        double monthlyPayment = monto * (tasa / 100); // cuota de la 1 a la n-1;
        double lastPayment = monto + monthlyPayment; // cuota n

        for (int i = 1; i < meses; i++) {
            cuotas.add(monthlyPayment);
        }
        cuotas.add(lastPayment);

        return cuotas;
    }
}
