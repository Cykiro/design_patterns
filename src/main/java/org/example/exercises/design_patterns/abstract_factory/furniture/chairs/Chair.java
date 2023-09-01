package org.example.exercises.design_patterns.abstract_factory.furniture.chairs;

import org.example.exercises.design_patterns.abstract_factory.FurnitureType;

public interface Chair {
    String sitOn();
    boolean hasLegs();
    default FurnitureType furnitureType(){
        return FurnitureType.CHAIR;
    };
}
