package org.example.exercises.design_patterns.strategy.impl;

import org.example.exercises.design_patterns.strategy.dijkstra.Dijkstra;
import org.example.exercises.design_patterns.strategy.dijkstra.Graph;
import org.example.exercises.design_patterns.strategy.dijkstra.Node;
import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.interface_strategy.RouteStrategy;
import org.example.exercises.design_patterns.strategy.route.RouteDetails;
import org.example.exercises.design_patterns.strategy.route.StrategyType;

import java.math.BigDecimal;
import java.util.List;

public class RoadStrategy implements RouteStrategy {
    @Override
    public RouteDetails buildRoute(City source, City destination) {
        Graph graph = createGraph(source, destination);
        RouteDetails routeDetails = extractRouteDetails(graph, destination);

        return routeDetails;
    }

    private static RouteDetails extractRouteDetails(Graph graph, City destination) {


        for (Node node : graph.getNodes()) {
            if (node.getName().equals(destination.name())) {
                return setValuesToRouteDetails(node);
            }
        }

        return null;
    }

    private static RouteDetails setValuesToRouteDetails(Node node) {
        RouteDetails routeDetails = new RouteDetails();
        List<Node> shortestPath = node.getShortestPath();
        String path = "";
        if (shortestPath != null) {
            for (Node pathNode : shortestPath) {
                path += pathNode.getName() + " --" + "[" + "]" + "--> ";
            }
            path += node.getName();
        } else {
            System.out.println("No path found.");
        }
        routeDetails.setPath(path);
        routeDetails.setLength(node.getDistance());
        routeDetails.setPrice(BigDecimal.valueOf(node.getDistance()));
        routeDetails.setTime(node.getDistance() / 100);
        return routeDetails;
    }

    @Override
    public Graph createGraph(City source, City destination) {
//odziedziczyc grafu i dodac przystanki
        Graph graph = getGraph();

        Node sourcePoint = null;
        Node destinationPoint = null;
        for (Node node : graph.getNodes()) {
            if (node.getName().equals(source.name())) {
                sourcePoint = node;
            }
            if (node.getName().equals(destination.name())) {
                destinationPoint = node;
            }
        }
        if (destinationPoint == null || sourcePoint == null) {
            throw new RuntimeException("Not possible to get to the destination");
        }
        graph = Dijkstra.calculateShortestPathFromSource(graph, sourcePoint, destinationPoint);
        return graph;
    }

    static Graph getGraph() {
        Node WROCLAW = new Node(City.WROCLAW);
        Node KRAKOW = new Node(City.KRAKOW);
        Node NOWY_SACZ = new Node(City.NOWY_SACZ);
        Node RZESZOW = new Node(City.RZESZOW);
        Node LUBLIN = new Node(City.LUBLIN);
        Node TARNOW = new Node(City.TARNOW);

        WROCLAW.addDestination(City.NOWY_SACZ, 150, StrategyType.ROAD);

        KRAKOW.addDestination(City.RZESZOW, 120, StrategyType.ROAD);
        KRAKOW.addDestination(City.LUBLIN, 150, StrategyType.ROAD);

        NOWY_SACZ.addDestination(City.LUBLIN, 100, StrategyType.ROAD);

        RZESZOW.addDestination(City.LUBLIN, 20, StrategyType.ROAD);
        RZESZOW.addDestination(City.TARNOW, 10, StrategyType.ROAD);

        TARNOW.addDestination(City.LUBLIN, 50, StrategyType.ROAD);

        Graph graph = new Graph();

        graph.addNode(WROCLAW);
        graph.addNode(KRAKOW);
        graph.addNode(NOWY_SACZ);
        graph.addNode(RZESZOW);
        graph.addNode(LUBLIN);
        graph.addNode(TARNOW);
        return graph;
    }
}
