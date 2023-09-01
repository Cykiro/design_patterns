package org.example.exercises.exercises;

public class Developer extends Employee {


    public Developer(String name, int age) {
        super(name, age);
    }

    @Override
    public String doJob() {
        return "Write code";
    }
    @Override
    public void drinkWater(){
        System.out.println("drinking cola");
    }
}
