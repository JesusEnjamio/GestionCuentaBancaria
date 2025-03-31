package de.jesus.cuenta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import de.jesus.cuenta.model.BancoCuentaAhorros;

@SpringBootTest
class CuentaApplicationTests {

	@Test
    void flujoCompletoConsignarRetirarExtracto() {
      
        BancoCuentaAhorros cuenta = new BancoCuentaAhorros(12000, 4.0f);

        boolean retiroExitoso = cuenta.retirar(2000);
        assertTrue(retiroExitoso);
        assertEquals(10000.0f, cuenta.getSaldo());

        cuenta.consignar(5000);
        assertEquals(15000.0f, cuenta.getSaldo());

        cuenta.extractoMensual();

        float interesEsperado = (15000.0f * (4.0f / 12)) / 100;
        float saldoEsperado = 15000.0f + interesEsperado;

        assertEquals(saldoEsperado, cuenta.getSaldo(), 0.01f);
    }

    @Test
    void cuentaDebeEstarActivaInicialmente() {
        BancoCuentaAhorros cuenta = new BancoCuentaAhorros(12000, 3.0f);
        assertTrue(cuenta.obtenerDetalles().contains("Activa: true"));
    }

    @Test
    void cuentaSeInactivaSiSaldoCaeBajo10mil() {
        BancoCuentaAhorros cuenta = new BancoCuentaAhorros(12000, 3.0f);
        cuenta.retirar(3000);
        cuenta.extractoMensual();
        assertTrue(cuenta.obtenerDetalles().contains("Activa: false"));
    }
}
