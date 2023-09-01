package org.example.exercises.design_patterns.abstract_factory.factories;

import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.Chair;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.Coffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();

    Coffetable createCoffetable();
}
