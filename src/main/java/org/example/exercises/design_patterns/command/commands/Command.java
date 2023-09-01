package org.example.exercises.design_patterns.command.commands;

import org.example.exercises.design_patterns.command.menu.MenuItem;

import java.util.List;

public abstract class Command {
    protected List<MenuItem> listItems;

    Command(List<MenuItem> listItems) {
        this.listItems = listItems;
    }

    public abstract void execute();

    public void cancel(){
        listItems.clear();
    };

    public int getPreparationTime() {
        return listItems.stream().map(MenuItem::getPreparationTime).reduce(0, Integer::sum);
    }
    public boolean areAllItemsReady() {
        for (MenuItem item : listItems) {
            if (!item.isReady()) {
                return false;
            }
        }
        return true;
    }

}