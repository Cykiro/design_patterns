package org.example.exercises.design_patterns.command.commands.executor;

import org.example.exercises.design_patterns.command.commands.Command;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TakeCommandtoStaff {
    private static int orderNumber = 1;

    public static void prepareFood(List<Command> commands) throws InterruptedException {
        System.out.println("\n Preparing order: #" + orderNumber);
        orderNumber++;
        ExecutorService executor = Executors.newFixedThreadPool(3);

        commands.forEach(command -> {
            executor.submit(new TaskExecutor(command));
        });
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

    }
    public static class TaskExecutor implements Callable {
        Command command;

        public TaskExecutor(Command command) {
            this.command = command;
        }

        @Override
        public Void call() throws Exception {
            command.execute();
            return null;
        }
    }
}
