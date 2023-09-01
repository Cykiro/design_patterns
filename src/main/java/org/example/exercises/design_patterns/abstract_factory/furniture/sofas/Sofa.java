package org.example.exercises.design_patterns.abstract_factory.furniture.sofas;

import org.example.exercises.design_patterns.abstract_factory.FurnitureType;

public interface Sofa {
    String sitOn();
    boolean hasLegs();

    default FurnitureType furnitureType(){
        return FurnitureType.SOFA;
    };

}
