package org.example.exercises.design_patterns.command.staff;

import org.example.exercises.design_patterns.command.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Chef {
    private List<MenuItem> ongoingOrders = new ArrayList<>();
    private ExecutorService executor = Executors.newFixedThreadPool(2);
    public void prepareDish(MenuItem item) {

        Runnable task = getRunnable(item);

        ongoingOrders.add(item);
        executor.submit(task);
    }

    private Runnable getRunnable(MenuItem item) {
        Runnable task = () -> {
            if (ongoingOrders.contains(item)) {
                ongoingOrders.remove(item);
                try {
                    Thread.sleep(1000);
                    System.out.println("Preparing dish: " + item.getName() + " for $" + item.getPrice());
                    Thread.sleep(item.getPreparationTime() * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //danie
                System.out.println("Dish " + item.getName() + " is ready!");
            }
        };
        return task;
    }

    public void cancelPreparation(MenuItem item) {
        if (ongoingOrders.contains(item)) {
            System.out.println("Canceling preparation of dish: " + item.getName());
            ongoingOrders.remove(item);
        }else{
            System.out.println("No item to cancel");
        }
    }
    public void shutdown() {
        executor.shutdown();
    }
    public void awaitTermination() {
        try {
            executor.awaitTermination(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MenuItem> getOngoingOrders() {
        return ongoingOrders;
    }
}
