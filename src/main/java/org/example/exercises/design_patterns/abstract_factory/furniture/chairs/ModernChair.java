package org.example.exercises.design_patterns.abstract_factory.furniture.chairs;

public class ModernChair implements Chair {
    @Override
    public String sitOn() {
        return "Modern chair";
    }

    @Override
    public boolean hasLegs() {
        return false;
    }
}
