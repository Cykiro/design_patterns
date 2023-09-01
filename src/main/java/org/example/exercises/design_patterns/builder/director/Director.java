package org.example.exercises.design_patterns.builder.director;

import org.example.exercises.design_patterns.builder.builders.Builder;
import org.example.exercises.design_patterns.builder.cars.CarType;
import org.example.exercises.design_patterns.builder.components.Engine;
import org.example.exercises.design_patterns.builder.components.GPSNavigator;
import org.example.exercises.design_patterns.builder.components.Transmission;
import org.example.exercises.design_patterns.builder.components.TripComputer;

public class Director {

    public void constructSportsCar(Builder builder) {
        builder.setCarType(CarType.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(300, 0,0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(150, 0,0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setCarType(CarType.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(120, 0,0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}