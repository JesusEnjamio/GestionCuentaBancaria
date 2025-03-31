package de.jesus.cuenta.model;

public class BancoCuentaAhorros extends BancoCuenta {
    private boolean activa;

    public BancoCuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
            verificarEstado();
        }
    }

    @Override
    public boolean retirar(float cantidad) {
        if (activa && super.retirar(cantidad)) {
            verificarEstado();
            return true;
        }
        return false;
    }

    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        verificarEstado();
    }

    private void verificarEstado() {
        activa = saldo >= 10000;
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Activa: " + activa;
    }
}