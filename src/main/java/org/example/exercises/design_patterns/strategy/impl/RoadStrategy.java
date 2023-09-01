package org.example.exercises.design_patterns.strategy.impl;

import org.example.exercises.design_patterns.strategy.dijkstra.Dijkstra;
import org.example.exercises.design_patterns.strategy.dijkstra.Graph;
import org.example.exercises.design_patterns.strategy.dijkstra.Node;
import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.interface_strategy.RouteStrategy;
import org.example.exercises.design_patterns.strategy.route.RouteDetails;

import java.math.BigDecimal;
import java.util.List;

public class RoadStrategy implements RouteStrategy {
    @Override
    public RouteDetails buildRoute(City source, City destination) {
        Graph graph = createGraph(source,destination);
        RouteDetails routeDetails = extractRouteDetails(graph,destination);

        return routeDetails;
    }

    private static RouteDetails extractRouteDetails(Graph graph, City destination) {


        for (Node node : graph.getNodes()) {
            if(node.getName().equals(destination.name())) {
                return setValuesToRouteDetails(node);
            }
        }

        return null;
    }

    private static RouteDetails setValuesToRouteDetails(Node node) {
        RouteDetails routeDetails = new RouteDetails();
        List<Node> shortestPath = node.getShortestPath();
        String path="";
        if (shortestPath != null) {
            for (Node pathNode : shortestPath) {
                path +=pathNode.getName() + " -> ";
            }
            path += node.getName();
        } else {
            System.out.println("No path found.");
        }
        routeDetails.setPath(path);
        routeDetails.setLength(node.getDistance());
        routeDetails.setPrice(BigDecimal.valueOf(node.getDistance()));
        routeDetails.setTime(node.getDistance()/100);
        return routeDetails;
    }

    @Override
    public Graph createGraph(City source, City destination) {
//odziedziczyc grafu i dodac przystanki
        Node nodeA = new Node(City.WROCLAW);
        Node nodeB = new Node(City.KRAKOW);
        Node nodeC = new Node(City.NOWY_SACZ);
        Node nodeD = new Node(City.RZESZOW);
        Node nodeE = new Node(City.LUBLIN);
        Node nodeF = new Node(City.TARNOW);

        nodeA.addDestination(nodeB, 100);
        nodeA.addDestination(nodeC, 150);

        nodeB.addDestination(nodeD, 120);
        nodeB.addDestination(nodeF, 210);

        nodeC.addDestination(nodeE, 100);

        nodeD.addDestination(nodeE, 20);
        nodeD.addDestination(nodeF, 100);

        nodeF.addDestination(nodeE, 50);

        nodeE.addDestination(nodeF, 50);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        Node sourcePoint = null;
        Node destinationPoint = null;
        for (Node node : graph.getNodes()) {
            if (node.getName().equals(source.name())){
                sourcePoint = node;
            }
            if (node.getName().equals(destination.name())){
                destinationPoint = node;
            }
        }
        graph = Dijkstra.calculateShortestPathFromSource(graph, sourcePoint, destinationPoint);
        return graph;
    }
}
