package org.example;


public abstract class CuentaBancaria {
    //Atributos
    private String brand;
    int velocity;
    private int wheels;

    //Constructor
    public Vehicle(String brand, int wheels){
        this.brand = brand;
        this.wheels = wheels;
        this.velocity = 0; // Default velocity
    }

    //Getters
    public String getBrand() {
        return brand;
    }
    public int getVelocity() {
        return velocity;
    }
    public int getWheels() {
        return wheels;
    }

    public abstract void accelerate();
    public abstract void brake();
}
