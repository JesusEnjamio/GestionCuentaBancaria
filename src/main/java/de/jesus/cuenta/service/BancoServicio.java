package de.jesus.cuenta.service;

import org.springframework.stereotype.Service;

import de.jesus.cuenta.model.BancoCuenta;

@Service
public class BancoServicio {
    public String obtenerDetalles(BancoCuenta cuenta) {
        return cuenta.obtenerDetalles();
    }
}
