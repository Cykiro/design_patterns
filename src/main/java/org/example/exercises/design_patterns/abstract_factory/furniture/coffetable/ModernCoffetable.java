package org.example.exercises.design_patterns.abstract_factory.furniture.coffetable;

public class ModernCoffetable implements Coffetable{
    @Override
    public String sitOn() {
        return "Modern coffe table";
    }

    @Override
    public boolean hasLegs() {
        return false;
    }
}
