package org.example.exercises.reflection;

public class Dog extends Animal implements Locomotion{
    public Dog(String name) {
        super(name);
    }


    @Override
    public String getSound() {
        return "woof";
    }
    @Override
    public String eats() {
        return "meat";
    }

    @Override
    public String getLocomotion() {
        return "walk";
    }
}
