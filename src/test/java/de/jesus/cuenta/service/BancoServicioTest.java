package de.jesus.cuenta.service;

import de.jesus.cuenta.model.BancoCuentaAhorros;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.jesus.cuenta.model.BancoCuenta;

class BancoServicioTest {

    @Test
void debeRetornarDetallesCorrectos() {
    BancoServicio servicio = new BancoServicio();
    BancoCuenta cuenta = new BancoCuentaAhorros(15000, 3.5f);

    cuenta.consignar(5000); 
    cuenta.retirar(2000);  

    String detalles = servicio.obtenerDetalles(cuenta);
    System.out.println("🔍 Detalles obtenidos: " + detalles);

    assertTrue(detalles.contains("Cuenta con saldo: 18000.0"));
    assertTrue(detalles.contains("Consignaciones: 1"));
    assertTrue(detalles.contains("Retiros: 1"));
}
}