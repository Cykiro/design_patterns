package org.example.exercises.thread;

public class ThreadExample extends Thread{
    public void run(){
        System.out.println("Hello from thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
