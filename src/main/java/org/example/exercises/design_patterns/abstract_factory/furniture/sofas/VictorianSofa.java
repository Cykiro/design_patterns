package org.example.exercises.design_patterns.abstract_factory.furniture.sofas;

public class VictorianSofa implements Sofa {
    @Override
    public String sitOn() {
        return "Victorian sofa";
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}