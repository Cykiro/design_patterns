package org.example.exercises.design_patterns.factory_method.logistics;


import org.example.exercises.design_patterns.factory_method.transport.Transport;
import org.example.exercises.design_patterns.factory_method.transport.Truck;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createDelivery() {
        return new Truck();
    }
}