package org.example.exercises.exercises;

public abstract class Employee {
   private String name;
   private int age;
   public Employee(String name, int age) {
      this.name = name;
      this.age = age;
   }


   public void drinkWater(){
      System.out.println("drinking water");
   }
   public abstract String doJob();
}
