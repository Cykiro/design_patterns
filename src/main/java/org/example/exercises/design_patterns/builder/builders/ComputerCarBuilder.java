package org.example.exercises.design_patterns.builder.builders;

import org.example.exercises.design_patterns.builder.cars.ComputerCar;
import org.example.exercises.design_patterns.builder.cars.CarType;
import org.example.exercises.design_patterns.builder.components.Engine;
import org.example.exercises.design_patterns.builder.components.GPSNavigator;
import org.example.exercises.design_patterns.builder.components.Transmission;
import org.example.exercises.design_patterns.builder.components.TripComputer;

public class ComputerCarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer=new TripComputer();
    private GPSNavigator gpsNavigator;
    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }


    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public ComputerCar getResult() {
        return new ComputerCar(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
