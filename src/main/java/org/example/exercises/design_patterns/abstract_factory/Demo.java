package org.example.exercises.design_patterns.abstract_factory;

import org.example.exercises.design_patterns.abstract_factory.application.FactoryApplication;
import org.example.exercises.design_patterns.abstract_factory.factories.ArtDecoFactory;
import org.example.exercises.design_patterns.abstract_factory.factories.FurnitureFactory;
import org.example.exercises.design_patterns.abstract_factory.factories.ModernFactory;
import org.example.exercises.design_patterns.abstract_factory.factories.VictorianFactory;

public class Demo {
    public static FactoryApplication chooseFurnitureStyle(FurnitureStyle furnitureStyle) {
        FactoryApplication app;
        FurnitureFactory factory = null;
        switch (furnitureStyle){
            case VICTORIAN ->  factory = new VictorianFactory();
            case MODERN ->  factory = new ModernFactory();
            case ART_DECO -> factory = new ArtDecoFactory();
        }

        app = new FactoryApplication(factory);
        return app;
    }



}
