package org.example.exercises.design_patterns.factory_method.logistics;

import org.example.exercises.design_patterns.factory_method.package_detail.Package;
import org.example.exercises.design_patterns.factory_method.transport.Transport;
import org.example.exercises.design_patterns.factory_method.transport.TransportType;

public abstract class Logistics {
    public TransportType planDelivery(Package aPackage) {
        Transport transport = createDelivery();
        return transport.deliver(aPackage);
    }

    public abstract Transport createDelivery();
}
