package de.jesus.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.jesus.cuenta.model.BancoCuenta;
import de.jesus.cuenta.model.BancoCuentaAhorros;

@SpringBootApplication
public class CuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuentaApplication.class, args);

		BancoCuenta cuenta = new BancoCuentaAhorros(12000, 4.0f);
        cuenta.retirar(2000);
        cuenta.consignar(5000);
        cuenta.extractoMensual();

        System.out.println(cuenta.obtenerDetalles());
	}

}
