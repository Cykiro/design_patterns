package org.example.exercises.design_patterns.strategy.dijkstra;


import org.example.exercises.design_patterns.strategy.interface_strategy.City;
import org.example.exercises.design_patterns.strategy.route.StrategyType;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node newNode) {

        boolean nodeExists = false;
        for(Node node: nodes){
            if(node.getName().equals(newNode.getName())){


                for(Map.Entry<City, Integer> entries: newNode.getAdjacentNodes().entrySet()){
                    StrategyType strategyType = null;
                    for(Map.Entry<City, StrategyType> entries2: newNode.getAdjacentStrategy().entrySet()) {
                            if(entries.getKey().equals(entries2.getKey())){
                                strategyType = entries2.getValue();
                            }
                    }
                    node.addDestination(entries.getKey(),entries.getValue(),strategyType);
                }



                nodeExists = true;
            }
        }

        if (!nodeExists) {
            nodes.add(newNode);
        }
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }



}
