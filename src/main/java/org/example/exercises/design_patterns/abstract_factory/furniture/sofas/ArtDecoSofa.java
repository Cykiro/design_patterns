package org.example.exercises.design_patterns.abstract_factory.furniture.sofas;

public class ArtDecoSofa implements Sofa{
    @Override
    public String sitOn() {
        return "Art deco sofa";
    }

    @Override
    public boolean hasLegs() {
        return false;
    }
}
