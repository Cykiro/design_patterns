package org.example.exercises.design_patterns.abstract_factory.application;

import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.Chair;
import org.example.exercises.design_patterns.abstract_factory.factories.FurnitureFactory;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.Coffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.Sofa;

public class FactoryApplication {
    private Chair chair;
    private Sofa sofa;
    private Coffetable coffetable;

    public FactoryApplication(FurnitureFactory factory) {
        chair = factory.createChair();
        sofa = factory.createSofa();
        coffetable = factory.createCoffetable();

    }

    public Chair getChair() {
        return chair;
    }

    public Sofa getSofa() {
        return sofa;
    }

    public Coffetable getCoffetable() {return coffetable; }
}
