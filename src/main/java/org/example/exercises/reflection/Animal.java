package org.example.exercises.reflection;

public abstract class Animal implements Eating {
    private String name;
    public abstract String getSound();

    public Animal(String name) {
        this.name = name;
    }
}
