package org.example.exercises.thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionExampleTest {
    @Test
    public void testMethod(){
        ExceptionExample.method();
        try {
            ExceptionExample.checkAge(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}