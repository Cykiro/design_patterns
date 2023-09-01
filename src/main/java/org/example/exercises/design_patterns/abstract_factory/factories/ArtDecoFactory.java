package org.example.exercises.design_patterns.abstract_factory.factories;

import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.ArtDecoChair;
import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.Chair;;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.ArtDecoCoffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.Coffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.ArtDecoSofa;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.Sofa;

public class ArtDecoFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }
    @Override
    public Coffetable createCoffetable() {
        return new ArtDecoCoffetable();
    }
}
