package org.example;

public class CuentaCorriente extends CuentaBancaria {

    private float sobregiro;


    // Constructor
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                setSobregiro(0);
                setSaldo(getSaldo() + (cantidad - sobregiro));
            } else {
                setSobregiro(sobregiro - cantidad);
            }
        } else {
            super.consignar(cantidad);
        }
        setNumeroDeConsignaciones(getNumeroDeConsignaciones() + 1);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= getSaldo()) {
            super.retirar(cantidad);
        } else {
            sobregiro += cantidad - getSaldo();
            super.retirar(getSaldo());
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public String toString() {
        return super.toString() + ", Sobregiro: " + sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }
}
