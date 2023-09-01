package org.example.exercises.design_patterns.builder.cars;

import org.example.exercises.design_patterns.builder.components.Engine;
import org.example.exercises.design_patterns.builder.components.GPSNavigator;
import org.example.exercises.design_patterns.builder.components.Transmission;

public class StandardCar {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final GPSNavigator gpsNavigator;

    public CarType getCarType() {
        return carType;
    }

    public StandardCar(CarType carType, int seats, Engine engine, Transmission transmission, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getPower() + "; mileage - " + engine.getMileage() + "\n";
        info += "Transmission: " + transmission + "\n";
        if (this.gpsNavigator != null) {
            info += "GPS Navigator: Functional" + "\n";
        } else {
            info += "GPS Navigator: N/A" + "\n";
        }
        return info;
    }
}