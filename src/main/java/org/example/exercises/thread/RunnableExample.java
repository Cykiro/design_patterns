package org.example.exercises.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RunnableExample implements Callable {
    @Override
    public String call() {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
