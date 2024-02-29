package org.example.exercises.design_patterns.command;

import org.example.exercises.design_patterns.command.commands.Command;
import org.example.exercises.design_patterns.command.commands.OrderCommand;

import org.example.exercises.design_patterns.command.commands.executor.TakeCommandtoStaff;
import org.example.exercises.design_patterns.command.menu.ItemType;
import org.example.exercises.design_patterns.command.menu.MenuItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DemoTest {
    static List<MenuItem> menu;

    @BeforeAll
    public static void createMenu() {
        MenuItem spaghetti = new MenuItem(ItemType.DISH, "Spaghetti Carbonara", 12.99, 5);
        MenuItem steak = new MenuItem(ItemType.DISH, "Grilled Steak", 24.99, 8);
        MenuItem soup = new MenuItem(ItemType.DISH, "Creamy Soup", 6.99, 4);
        MenuItem pizza = new MenuItem(ItemType.DISH, "Margherita Pizza", 15.99, 10);
        MenuItem apple_pie = new MenuItem(ItemType.DISH, "Apple pie", 5.99, 2);
        MenuItem cola = new MenuItem(ItemType.DRINK, "Cola", 3.99, 1);
        MenuItem water = new MenuItem(ItemType.DRINK, "Water", 1.99, 1);

        menu = new ArrayList<>();
        menu.add(spaghetti);
        menu.add(steak);
        menu.add(soup);
        menu.add(pizza);
        menu.add(apple_pie);
        menu.add(cola);
        menu.add(water);

    }

    @Test
    public void shouldMakeOrder() throws InterruptedException {
        List<MenuItem> order = new ArrayList<>();
        order.add(new MenuItem(menu.get(0)));
        order.add(new MenuItem(menu.get(1)));
        order.add(new MenuItem(menu.get(4)));
        order.add(new MenuItem(menu.get(5)));
        OrderCommand orderCommand = new OrderCommand();

        List<Command> commands = orderCommand.placeOrder(order);
        TakeCommandtoStaff.prepareFood(commands);

        assertThat(orderCommand.getPreparationTime()).isEqualTo(16);
        assertThat(orderCommand.areAllItemsReady()).isTrue();



        List<MenuItem> order2 = new ArrayList<>();
        order2.add(new MenuItem(menu.get(0)));
        order2.add(new MenuItem(menu.get(1)));

        List<Command> commands2 = orderCommand.placeOrder(order2);
        TakeCommandtoStaff.prepareFood(commands2);

        assertThat(orderCommand.getPreparationTime()).isEqualTo(13);
        assertThat(orderCommand.areAllItemsReady()).isTrue();

    }
}
