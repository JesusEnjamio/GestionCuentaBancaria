package de.jesus.cuenta.model;

public class BancoCuentaCorriente extends BancoCuenta {
    private float sobregiro = 0;

    public BancoCuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public boolean retirar(float cantidad) {
        if (cantidad <= saldo) {
            return super.retirar(cantidad);
        } else {
            sobregiro += (cantidad - saldo);
            saldo = 0;
            numeroRetiros++;
            return true;
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                saldo += (cantidad - sobregiro);
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Sobregiro: " + sobregiro;
    }
    public float getSobregiro() {
        return sobregiro;
    }
}