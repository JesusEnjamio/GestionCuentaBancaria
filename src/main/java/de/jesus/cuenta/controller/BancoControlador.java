package de.jesus.cuenta.controller;

import de.jesus.cuenta.model.BancoCuenta;
import de.jesus.cuenta.model.BancoCuentaAhorros;
import de.jesus.cuenta.service.BancoServicio;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/banco", method = RequestMethod.POST)
public class BancoControlador {

    private final BancoServicio bancoServicio;

    public BancoControlador(BancoServicio bancoServicio) {
        this.bancoServicio = bancoServicio;
    }

    @PostMapping("/detalles")
    public String obtenerDetalles(@RequestBody BancoCuentaAhorros cuenta) {
        return bancoServicio.obtenerDetalles(cuenta);
    }
}
