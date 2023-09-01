package org.example.exercises.exercises;

public interface Animal {
    String name = "";
    public String sound();
    default public void sleep(){
        System.out.println("sleep");
    }

}
