package org.example.exercises.design_patterns.factory_method;
import org.example.exercises.design_patterns.factory_method.logistics.Logistics;
import org.example.exercises.design_patterns.factory_method.logistics.RoadLogistics;
import org.example.exercises.design_patterns.factory_method.logistics.SeaLogistics;
import org.example.exercises.design_patterns.factory_method.package_detail.Package;
import org.example.exercises.design_patterns.factory_method.transport.TransportType;

public class Demo {
    private Logistics logistics;

    public TransportType process(Package aPackage) {
        if (aPackage.getPackageWeight() > 1500) {
            logistics = new SeaLogistics();
        } else {
            logistics = new RoadLogistics();
        }
        return logistics.planDelivery(aPackage);
    }
}
