package org.example.exercises.design_patterns.builder;

import org.example.exercises.design_patterns.builder.builders.ComputerCarBuilder;
import org.example.exercises.design_patterns.builder.builders.StandardCarBuilder;
import org.example.exercises.design_patterns.builder.cars.ComputerCar;
import org.example.exercises.design_patterns.builder.cars.StandardCar;
import org.example.exercises.design_patterns.builder.director.Director;

public class Demo {

    public static void main(String[] args) {
        Director director = new Director();


        ComputerCarBuilder builder = new ComputerCarBuilder();
        director.constructSportsCar(builder);
        ComputerCar computerCar = builder.getResult();
        System.out.println("Car built:\n" + computerCar.print());

        StandardCarBuilder standardCarBuilder = new StandardCarBuilder();
        director.constructSportsCar(standardCarBuilder);
        StandardCar carStandardCar = standardCarBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carStandardCar.print());
    }

}