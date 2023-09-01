package org.example.exercises.design_patterns.command.commands;

import org.example.exercises.design_patterns.command.menu.MenuItem;

import java.util.List;

public class DishMakerCommand extends Command {
    DishMakerCommand(List<MenuItem> listItems) {
        super(listItems);
    }

    @Override
    public void execute() {
        listItems.forEach(item -> {
            try {
                Thread.sleep(item.getPreparationTime() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Making dish:" + item.getName() + " for $" + item.getPrice());
            item.setReady();
        });

    }
}
