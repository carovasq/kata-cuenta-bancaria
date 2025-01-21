package org.example;

// Base Class
public abstract class CuentaBancaria {

    //Atributos
    private float saldo;
    private int numeroDeConsignaciones;
    private int numeroDeRetiros;
    private float tasaAnual;
    private float comisionMensual;


    //Constructor
    public CuentaBancaria(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.numeroDeConsignaciones = 0; //Default init 0
        this.numeroDeRetiros = 0; //Default init 0
        this.tasaAnual = tasaAnual;
        this.comisionMensual = 0; //Default init 0
    }



    //Methods
    public void consignar(float cantidad) {
        saldo += cantidad;
        numeroDeConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numeroDeRetiros++;
        } else {
            System.out.println("No hay suficiente saldo.");
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = saldo * (tasaAnual / 12) / 100;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "saldo=" + saldo +
                ", numeroDeConsignaciones=" + numeroDeConsignaciones +
                ", numeroDeRetiros=" + numeroDeRetiros +
                ", tasaAnual=" + tasaAnual +
                ", comisionMensual=" + comisionMensual +
                '}';
    }


    //Getters
    public float getSaldo() {
        return saldo;
    }

    public int getNumeroDeConsignaciones() {
        return numeroDeConsignaciones;
    }

    public int getNumeroDeRetiros() {
        return numeroDeRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    //Setters


    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setNumeroDeConsignaciones(int numeroDeConsignaciones) {
        this.numeroDeConsignaciones = numeroDeConsignaciones;
    }

    public void setNumeroDeRetiros(int numeroDeRetiros) {
        this.numeroDeRetiros = numeroDeRetiros;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
}
