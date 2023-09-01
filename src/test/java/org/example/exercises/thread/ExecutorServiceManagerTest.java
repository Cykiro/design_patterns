package org.example.exercises.thread;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

class ExecutorServiceManagerTest {
    @Test
    public void testNothing() throws IOException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Callable<String> callableTask = () -> {
            Thread.sleep(getRandomNumber(1000,5000));
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            System.out.println("nothing");
            return now.toString();
        };
        List<Callable<String>> callableTasks = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            callableTasks.add(callableTask);
        }
        List<Future<String>> futures = executor.invokeAll(callableTasks);

        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdownNow();

//        executor.execute(runnableTask);
//        executor.shutdown();
//        System.out.println(executor.isTerminated());
//        Thread.sleep(5000);
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}