package org.example.exercises.design_patterns.factory_method.transport;


import org.example.exercises.design_patterns.factory_method.package_detail.Package;

public class Truck implements Transport {
    public TransportType deliver(Package aPackage) {
        return TransportType.TRUCK;
    }


}