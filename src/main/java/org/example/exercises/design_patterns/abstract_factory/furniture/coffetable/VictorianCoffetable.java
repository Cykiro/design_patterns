package org.example.exercises.design_patterns.abstract_factory.furniture.coffetable;

public class VictorianCoffetable implements Coffetable{
    @Override
    public String sitOn() {
        return "Victorian coffe table";
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
