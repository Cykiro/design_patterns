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


public class WalkingStrategy implements RouteStrategy {
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
        routeDetails.setPrice(BigDecimal.valueOf(0));
        routeDetails.setTime(node.getDistance() / 5);
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


        WROCLAW.addDestination(City.KRAKOW, 100, StrategyType.WALKING);
        Graph graph = new Graph();
        graph.addNode(WROCLAW);

        return graph;
    }
}


