package org.example.exercises.thread;

public class ExceptionExample {
    public static void method() {
        int[] tab = {1, 2, 3, 4, 5, 6};
        try {
            System.out.println(tab[-1]);
        } catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("My error");
        } finally {
            System.out.println("Hello from finally");
        }
    }
    public static void checkAge(int age) throws InterruptedException {
        if(age<18){
            throw new ArithmeticException("Access denied");
        } else {
            System.out.println("Access granted");
        }
        Thread.sleep(100);
    }
}
