package org.example.exercises.design_patterns.strategy;

import org.example.exercises.design_patterns.strategy.impl.RoadStrategy;
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
        }  else {
            throw new RuntimeException("Strategy type not supported");
        }

        return routeStrategy.buildRoute(source, destination);
    }

}
