package com.example.demo.controller;

import com.example.demo.application.SimuladorPrestamoService;
import com.example.demo.domain.DetallePrestamo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prestamos")
public class PrestamosController {

    private final SimuladorPrestamoService simuladorPrestamoService;

    public PrestamosController(SimuladorPrestamoService simuladorPrestamoService){
        this.simuladorPrestamoService = simuladorPrestamoService;
    }

    @GetMapping("/simular")
    public DetallePrestamo simular(@RequestParam double monto, @RequestParam int meses, @RequestParam int sistema){
        return simuladorPrestamoService.simularPrestamo(monto, meses, sistema);
    }
}
