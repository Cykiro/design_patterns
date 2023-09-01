package org.example.exercises.design_patterns.abstract_factory.factories;

import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.Chair;
import org.example.exercises.design_patterns.abstract_factory.furniture.chairs.ModernChair;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.Coffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.coffetable.ModernCoffetable;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.ModernSofa;
import org.example.exercises.design_patterns.abstract_factory.furniture.sofas.Sofa;

public class ModernFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
    @Override
    public Coffetable createCoffetable() {
        return new ModernCoffetable();
    }


}
