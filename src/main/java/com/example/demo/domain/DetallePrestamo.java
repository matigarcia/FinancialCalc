package com.example.demo.domain;

import java.util.List;

public class DetallePrestamo {
    private final Double montoFinal;
    private final List<Double> cuotas;

    public DetallePrestamo(Double montoFinal, List<Double> cuotas) {
        this.montoFinal = montoFinal;
        this.cuotas = cuotas;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public List<Double> getCuotas() {
        return cuotas;
    }
}
