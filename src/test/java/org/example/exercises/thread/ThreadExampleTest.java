package org.example.exercises.thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadExampleTest {
    @Test
    public void shouldPrintTextFromThread() throws InterruptedException {
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
        threadExample.join();
        System.out.println("Hi there");
    }

}