package org.example.exercises.exercises;

public class Dog implements Animal {

    @Override
    public String sound() {return "woof";}

    @Override
    public void sleep() {
        Animal.super.sleep();
    }
}
