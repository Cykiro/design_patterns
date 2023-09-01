package org.example.exercises.thread.files;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiManager {
    public static int multiManager() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int result=0;

        List<Callable<Integer>> callableTasks = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            callableTasks.add(new CallableCreator("file"+(i+1)+".txt"));
        }

        List<Future<Integer>> futures = executor.invokeAll(callableTasks);

        for (Future<Integer> future : futures) {
            try {
                result += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        executor.shutdownNow();
        return result;
    }
}
