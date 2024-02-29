package org.example.exercises.design_patterns.strategy.dijkstra;

import org.example.exercises.design_patterns.strategy.interface_strategy.City;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    public static Graph calculateShortestPathFromSource(Graph graph, Node source, Node destination) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            if(currentNode.getName().equals(destination.getName())){
                unsettledNodes.remove(currentNode);
                settledNodes.add(currentNode);
                continue;
            }
            unsettledNodes.remove(currentNode);
            for (Map.Entry<City, Integer> adjacencyPair_temp:  currentNode.getAdjacentNodes().entrySet()) {
                Node key = null;
                for(Node node: graph.getNodes()){
                    if(node.getName().equals(adjacencyPair_temp.getKey().toString())){
                        key = node;
                    }
                }


                Node adjacentNode = key;
                Integer edgeWeight = adjacencyPair_temp.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
    private static Node getLowestDistanceNode(Set <Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
