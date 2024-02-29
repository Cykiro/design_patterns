package org.example.exercises.design_patterns.strategy.dijkstra;

import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.interface_strategy.RouteStrategy;
import org.example.exercises.design_patterns.strategy.route.StrategyType;

import java.util.*;

public class Node {
    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;


    Map<City, Integer> adjacentNodes = new HashMap<>();
    Map<City, StrategyType> adjacentStrategy = new HashMap<>();
    public void addDestination(City destination, int distance, StrategyType strategyType) {
        adjacentNodes.put(destination, distance);
        adjacentStrategy.put(destination, strategyType);
    }

    public Node(City destinations) {

        this.name = destinations.name();
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<City, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Map<City, StrategyType> getAdjacentStrategy() {
        return adjacentStrategy;
    }
}
