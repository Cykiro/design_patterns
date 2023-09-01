package org.example.exercises.design_patterns.strategy.interface_strategy;

import org.example.exercises.design_patterns.strategy.dijkstra.Graph;
import org.example.exercises.design_patterns.strategy.route.RouteDetails;

public interface RouteStrategy {
     RouteDetails buildRoute(City source, City destination);
     Graph createGraph(City string, City destination);
}
