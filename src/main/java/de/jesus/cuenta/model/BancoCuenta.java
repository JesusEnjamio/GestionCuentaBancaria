package de.jesus.cuenta.model;

public abstract class BancoCuenta {
    protected float saldo;
    protected int numeroConsignaciones = 0;
    protected int numeroRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public BancoCuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numeroConsignaciones++;
        }
    }

    public boolean retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
            return true;
        }
        return false;
    }

    public void calcularInteresMensual() {
        float interesMensual = (saldo * (tasaAnual / 12)) / 100;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public String obtenerDetalles() {
        return "Cuenta con saldo: " + saldo + ", Consignaciones: " + numeroConsignaciones + ", Retiros: " + numeroRetiros;
    }

    public float getSaldo() {
        return saldo;
    }
}
