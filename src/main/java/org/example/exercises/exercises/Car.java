package org.example.exercises.exercises;

public class Car extends Vehicle {
    private String brand;
    private String model;

    public Car() {
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                '}';
    }
    @Override
    public String whatIsThis() {
        return "Car";
    }
}
