package org.example.exercises.exercises;

public class Plain {
    public boolean checkIfYouAreAdult(int age) {
        if (age < 18) {
            return false;
        } else {
            return true;
        }
    }
    public static boolean checkIfYouAreAdultStatic(int age) {
        if (age < 18) {
            return false;
        } else {
            return true;
        }
    }
}
