package org.example.exercises.design_patterns.factory_method.logistics;


import org.example.exercises.design_patterns.factory_method.transport.Transport;
import org.example.exercises.design_patterns.factory_method.transport.Ship;

public class SeaLogistics extends Logistics {

    @Override
    public Transport createDelivery() {
        return new Ship();
    }
}
