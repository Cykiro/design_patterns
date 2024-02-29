package org.example.exercises.design_patterns.strategy.impl;

import org.example.exercises.design_patterns.strategy.dijkstra.Dijkstra;
import org.example.exercises.design_patterns.strategy.dijkstra.Graph;
import org.example.exercises.design_patterns.strategy.dijkstra.Node;
import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.interface_strategy.RouteStrategy;
import org.example.exercises.design_patterns.strategy.route.RouteDetails;
import org.example.exercises.design_patterns.strategy.route.StrategyType;

import java.math.BigDecimal;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllTranposrtStrategy implements RouteStrategy {

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
        shortestPath.add(node);
        String path="";
        if (shortestPath != null) {
            for (int i = 0; i < shortestPath.size()-1; i++) {
                Node pathNode = shortestPath.get(i);

                path += pathNode.getName() + " --"+"[";
                for (Map.Entry<City, StrategyType> entry : pathNode.getAdjacentStrategy().entrySet()) {
                    if(entry.getKey().toString()==shortestPath.get(i+1).getName()){
                        path +=entry.getValue();
                    }
                }
                path+="]"+"--> ";



            }
            path += node.getName();
        } else {
            System.out.println("No path found.");
        }
        routeDetails.setPath(path);
        routeDetails.setLength(node.getDistance());
        routeDetails.setPrice(BigDecimal.valueOf(node.getDistance()/2)) ;
        routeDetails.setTime(node.getDistance()/50);
        return routeDetails;
    }

    @Override
    public Graph createGraph(City source, City destination) {

        WalkingStrategy walkingStrategy = new WalkingStrategy();
        RoadStrategy roadStrategy = new RoadStrategy();
        PublicTransportStrategy publicTransportStrategy = new PublicTransportStrategy();

        Set <Node>nodes1 = walkingStrategy.getGraph().getNodes();
        Set <Node>nodes2 = roadStrategy.getGraph().getNodes();
        Set <Node>nodes3 = publicTransportStrategy.getGraph().getNodes();
        Graph graph = new Graph();
        for (Node node : nodes1) {
            graph.addNode(node);
        }
        for (Node node : nodes2) {
            graph.addNode(node);
        }for (Node node : nodes3) {
            graph.addNode(node);
        }





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
        if(destinationPoint == null || sourcePoint == null) {
            throw new RuntimeException("Not possible to get to the destination");
        }
        graph = Dijkstra.calculateShortestPathFromSource(graph, sourcePoint, destinationPoint);
        return graph;
    }
}
