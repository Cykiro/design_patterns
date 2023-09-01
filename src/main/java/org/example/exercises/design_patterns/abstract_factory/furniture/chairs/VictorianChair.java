package org.example.exercises.design_patterns.abstract_factory.furniture.chairs;

public class VictorianChair implements Chair{
    @Override
    public String sitOn() {

        return "Victorian chair";
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
