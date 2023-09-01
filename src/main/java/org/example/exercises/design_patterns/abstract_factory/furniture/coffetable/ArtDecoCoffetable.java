package org.example.exercises.design_patterns.abstract_factory.furniture.coffetable;

public class ArtDecoCoffetable implements Coffetable{
    @Override
    public String sitOn() {
        return  "Art deco coffe table";
    }

    @Override
    public boolean hasLegs() {
        return true;
    }
}
