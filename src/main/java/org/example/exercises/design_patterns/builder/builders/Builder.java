package org.example.exercises.design_patterns.builder.builders;

import org.example.exercises.design_patterns.builder.cars.CarType;
import org.example.exercises.design_patterns.builder.components.Engine;
import org.example.exercises.design_patterns.builder.components.GPSNavigator;
import org.example.exercises.design_patterns.builder.components.Transmission;
import org.example.exercises.design_patterns.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}