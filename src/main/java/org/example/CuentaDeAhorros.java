package org.example;

public class CuentaDeAhorros extends CuentaBancaria {

    private boolean cuentaActiva;


    // Constructor
    public CuentaDeAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.cuentaActiva = saldo >= 10000;
    }


    @Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (cuentaActiva) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {
        if (cuentaActiva) {
            if (getNumeroDeRetiros() > 4) {
                float comisionAdicional = (getNumeroDeRetiros() - 4) * 1000;
                setComisionMensual(getComisionMensual() + comisionAdicional);
            }
        } else {
            System.out.println("La cuenta está inactiva. No se puede consignar.");
        }
        float saldoDespuesDeComision = getSaldo() - getComisionMensual();
        if (saldoDespuesDeComision < 0)
            saldoDespuesDeComision = 0;

        setSaldo(saldoDespuesDeComision);
        float intereses = (getSaldo() * getTasaAnual()) / 100;
        setSaldo(getSaldo() + intereses);
        cuentaActiva = getSaldo() >= 10000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Activa: " + cuentaActiva;
    }

}
