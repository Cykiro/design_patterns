package org.example.exercises.design_patterns.abstract_factory.furniture.chairs;

public class ArtDecoChair implements Chair{
    @Override
    public String sitOn() {
        return  "Art deco chair";
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
