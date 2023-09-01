package org.example.exercises.design_patterns.abstract_factory.furniture.sofas;


public class ModernSofa implements Sofa {
    @Override
    public String sitOn() {
       return "Modern sofa";
    }

    @Override
    public boolean hasLegs() {
        return false;
    }
}