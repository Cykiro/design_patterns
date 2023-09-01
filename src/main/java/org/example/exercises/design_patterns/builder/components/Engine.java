package org.example.exercises.design_patterns.builder.components;

import static java.lang.Math.pow;

public class Engine {
    private final double power;
    private double mileage;
    private boolean started;

    private double fuel = 0;

    public Engine(double power, double mileage, double fuel) {
        this.power = power;
        this.mileage = mileage;
        this.fuel = fuel;
    }

    public void on() {
        started = true;
    }

    public void off() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }


    public void go(double mileage) {
        if (started) {
            try {
                recalculateFuelLevel(mileage);
            } catch (ArithmeticException exception){
               throw new RuntimeException(exception);
            } finally {
                fuel*=100;
                fuel=Math.round(fuel);
                fuel/=100;
            }

        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }

    private void recalculateFuelLevel(double mileage) {
        while(mileage >0) {
            this.mileage ++;
            fuel -= (0.08*pow(power,0.33));
            mileage--;
            if(fuel<(0.08*pow(power,0.33))){
                throw new ArithmeticException("Cannot go futher, there is still: "+ mileage +" millage left");
            }
        }
    }

    public void tank(double fuel) {
       this.fuel+=fuel;
    }
    public int howFar() {
        return (int) (fuel/(0.08*pow(power,0.33)));
    }

    public double getPower() {
        return power;
    }

    public double getMileage() {
        return mileage;
    }
    public double getFuel() {
        return fuel;
    }
}