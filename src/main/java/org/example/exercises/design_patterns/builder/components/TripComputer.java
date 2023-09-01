package org.example.exercises.design_patterns.builder.components;

import org.example.exercises.design_patterns.builder.cars.ComputerCar;

public class TripComputer {

    private ComputerCar computerCar;

    public void setCar(ComputerCar computerCar) {
        this.computerCar = computerCar;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + computerCar.getEngine().getFuel());
    }

    public void showStatus() {
        if (this.computerCar.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}