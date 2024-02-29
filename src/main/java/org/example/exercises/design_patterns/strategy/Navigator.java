package org.example.exercises.design_patterns.strategy;

import org.example.exercises.design_patterns.strategy.impl.AllTranposrtStrategy;
import org.example.exercises.design_patterns.strategy.impl.PublicTransportStrategy;
import org.example.exercises.design_patterns.strategy.impl.RoadStrategy;
import org.example.exercises.design_patterns.strategy.impl.WalkingStrategy;
import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.interface_strategy.RouteStrategy;
import org.example.exercises.design_patterns.strategy.route.RouteDetails;
import org.example.exercises.design_patterns.strategy.route.StrategyType;

public class Navigator {
    private StrategyType strategyType;

    public Navigator(StrategyType strategyType) {
        this.strategyType = strategyType;
    }

    public RouteDetails buildRoute(City source, City destination) {
        RouteStrategy routeStrategy;
        if (strategyType.equals(StrategyType.ROAD)) {
            routeStrategy = new RoadStrategy();
        } else if (strategyType.equals(StrategyType.WALKING)) {
            routeStrategy = new WalkingStrategy();
        } else if (strategyType.equals(StrategyType.PUBLIC_TRANSPORT)) {
            routeStrategy = new PublicTransportStrategy();
        } else if (strategyType.equals(StrategyType.ALL)) {
            routeStrategy = new AllTranposrtStrategy();
        } else {
            throw new RuntimeException("Strategy type not supported");
        }
        RouteDetails routeDetails = routeStrategy.buildRoute(source, destination);
        if(routeDetails.getLength()==Integer.MAX_VALUE) {
            throw new RuntimeException("Not possible to get to the destination");
        }
        return routeDetails;
    }

}
