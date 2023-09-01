package org.example.exercises.design_patterns.abstract_factory.furniture.coffetable;

import org.example.exercises.design_patterns.abstract_factory.FurnitureType;

public interface Coffetable {
    String sitOn();
    boolean hasLegs();

    default FurnitureType furnitureType(){
        return FurnitureType.COFFETABLE;
    };

}
