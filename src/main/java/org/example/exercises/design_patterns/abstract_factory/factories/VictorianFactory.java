package org.example.exercises.design_patterns.abstract_factory.factories;

import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.Chair;
import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.VictorianChair;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.Coffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.VictorianCoffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.Sofa;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.VictorianSofa;

public class VictorianFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Coffetable createCoffetable() {return new VictorianCoffetable();}
}
