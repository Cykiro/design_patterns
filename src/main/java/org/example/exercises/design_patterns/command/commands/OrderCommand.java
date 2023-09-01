package org.example.exercises.design_patterns.command.commands;

import org.example.exercises.design_patterns.command.menu.ItemType;
import org.example.exercises.design_patterns.command.menu.MenuItem;
import org.example.exercises.design_patterns.command.staff.Chef;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderCommand {
    DishMakerCommand dishMakerCommand;
    DrinkMakerCommand drinkMakerCommand;
    CakeMakerCommand cakeMakerCommand;
    public List<Command> placeOrder(List<MenuItem> listItems){
        dishMakerCommand= new DishMakerCommand(groupItemsByType(listItems,ItemType.DISH));
        drinkMakerCommand= new DrinkMakerCommand(groupItemsByType(listItems,ItemType.DRINK));
        cakeMakerCommand= new CakeMakerCommand(groupItemsByType(listItems,ItemType.CAKE));


        List<Command> listCommands= new ArrayList<>();
        listCommands.add(dishMakerCommand);
        listCommands.add(drinkMakerCommand);
        listCommands.add(cakeMakerCommand);

        return listCommands;
    }

    private static List<MenuItem> groupItemsByType(List<MenuItem> listItems,ItemType itemType) {
        return listItems.stream().filter(menuItem -> menuItem.getItemType().equals(itemType)).collect(Collectors.toList());
    }

    public int getPreparationTime() {
        return drinkMakerCommand.getPreparationTime()+dishMakerCommand.getPreparationTime()+ cakeMakerCommand.getPreparationTime();
    }
    public boolean areAllItemsReady() {
        return dishMakerCommand.areAllItemsReady() && drinkMakerCommand.areAllItemsReady() && cakeMakerCommand.areAllItemsReady();
    }
}
