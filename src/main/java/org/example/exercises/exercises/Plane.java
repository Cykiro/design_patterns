package org.example.exercises.exercises;

public class Plane extends Vehicle   {
    private String manufacter;

    public Plane(String manufacter) {
        this.manufacter = manufacter;
    }


    @Override
    public String toString() {
        return "Plane{" +
                "manufacter='" + manufacter + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                '}';
    }
    @Override
    public String whatIsThis() {
        return "Plane";
    }
}
