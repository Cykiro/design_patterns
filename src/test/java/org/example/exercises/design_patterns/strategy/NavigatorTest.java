package org.example.exercises.design_patterns.strategy;
import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.route.RouteDetails;
import org.example.exercises.design_patterns.strategy.route.StrategyType;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NavigatorTest {
    @Test
    public void createRoadStrategy() {
        Navigator navigator = new Navigator(StrategyType.ROAD);
        RouteDetails routeDetails = navigator.buildRoute(City.WROCLAW, City.LUBLIN);
        System.out.println(routeDetails.getPath());
        assertThat(routeDetails.getLength()).isEqualTo(250);
        assertThat(routeDetails.getPrice()).isEqualTo(BigDecimal.valueOf(250));
        assertThat(routeDetails.getTime()).isEqualTo(2);
    }
    @Test
    public void createRoadStrategy2() {
        Navigator navigator = new Navigator(StrategyType.ALL);
        RouteDetails routeDetails = navigator.buildRoute(City.WROCLAW, City.TARNOW);
        System.out.println(routeDetails.getPath());
        assertThat(routeDetails.getLength()).isEqualTo(220);
        assertThat(routeDetails.getPrice()).isEqualTo(BigDecimal.valueOf(110));
        assertThat(routeDetails.getTime()).isEqualTo(4);
    }

    //czas dodac do drogi

}