package org.example.exercises.exercises;

public class Cat implements Animal {

    @Override
    public String sound() {
        return "miau";
    }

    @Override
    public void sleep() {
        Animal.super.sleep();
    }
}
