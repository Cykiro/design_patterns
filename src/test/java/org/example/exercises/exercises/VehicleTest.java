package org.example.exercises.exercises;

import org.example.exercises.exercises.Car;
import org.example.exercises.exercises.Carspec;
import org.example.exercises.exercises.Plane;
import org.example.exercises.exercises.Vehicle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class VehicleTest {

    @Test
    public void shouldSetType() {

        Vehicle car = new Car("Audi","A3");
        Vehicle car2= new Carspec();
        car.setMaxSpeed(100);
        car.whatIsThis();
        Vehicle plane = new Plane("Aircraft");

        assertThat(car.whatIsThis()).isExactlyInstanceOf(String.class);
        assertThat(car.whatIsThis()).isEqualTo("Car");
        assertThat(plane.whatIsThis()).isEqualTo("Plane");
        assertThat(car2.whatIsThis()).isEqualTo("Carspec");

    }
}