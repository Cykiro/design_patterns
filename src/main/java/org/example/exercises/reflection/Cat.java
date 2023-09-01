package org.example.exercises.reflection;

public class Cat extends Animal {
    public Cat(String s) {
        super("cat");
    }

    @Override
    public String getSound() {
        return null;
    }

    @Override
    public String eats() {
        return null;
    }
}
