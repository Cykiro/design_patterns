package org.example.exercises.exercises;

public class Vehicle {
    String type = "Vehicle";
    private int distanceTravelled=0;

    private Integer maxSpeed;

    public Vehicle() {
    }

    public String whatIsThis() {
        return "vehicle";
    }

    public void setMaxSpeed(Integer speed) {
        maxSpeed = speed;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void adddistanceTravelled(int number){distanceTravelled+=number;}

    public int getDistanceTravelled() {
        return distanceTravelled;
    }
}
