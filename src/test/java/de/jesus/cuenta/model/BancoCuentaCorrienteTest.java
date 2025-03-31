package de.jesus.cuenta.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BancoCuentaCorrienteTest {

    @Test
    void debeRetirarDentroDelSaldoSinSobregiro() {
        BancoCuentaCorriente cuenta = new BancoCuentaCorriente(1000, 3.0f);
        boolean resultado = cuenta.retirar(500);
        assertTrue(resultado);
        assertEquals(500, cuenta.getSaldo());
    }

    @Test
    void debePermitirSobregiroSiRetiroSuperaSaldo() {
        BancoCuentaCorriente cuenta = new BancoCuentaCorriente(1000, 3.0f);
        boolean resultado = cuenta.retirar(1500);
        assertTrue(resultado);
        assertEquals(0, cuenta.getSaldo());
        assertEquals(500, cuenta.getSobregiro());
    }

    @Test
    void debeReducirSobregiroConConsignacionCompleta() {
        BancoCuentaCorriente cuenta = new BancoCuentaCorriente(0, 3.0f);
        cuenta.retirar(1000);
        cuenta.consignar(1500);
        assertEquals(0, cuenta.getSobregiro());
        assertEquals(500, cuenta.getSaldo());
    }

    @Test
    void debeReducirSobregiroConConsignacionParcial() {
        BancoCuentaCorriente cuenta = new BancoCuentaCorriente(0, 3.0f);
        cuenta.retirar(800);
        cuenta.consignar(500);
        assertEquals(300, cuenta.getSobregiro());
        assertEquals(0, cuenta.getSaldo());
    }

    @Test
    void debeRetornarDetallesConSobregiro() {
        BancoCuentaCorriente cuenta = new BancoCuentaCorriente(1000, 3.0f);
        cuenta.retirar(1500);
        String detalles = cuenta.obtenerDetalles();
        assertTrue(detalles.contains("Sobregiro: 500.0"));
    }
}
