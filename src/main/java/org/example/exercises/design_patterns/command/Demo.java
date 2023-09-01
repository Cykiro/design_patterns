package org.example.exercises.design_patterns.command;

public class Demo {
//    public static void main(String[] args) {
//        Chef chef = new Chef();
//        Waiter waiter = new Waiter();
//        List<MenuItem> menu = getMenuItems();
//
//        PriorityQueue<Command> ordersQueue = getCommands(chef, menu);
//
//        while (!ordersQueue.isEmpty()) {
//            waiter.takeOrder(ordersQueue.poll());
//        }
//
//        chef.shutdown();
//    }
//
//
//    private static PriorityQueue<Command> getCommands(Chef chef, List<MenuItem> menu) {
//        Scanner scanner = new Scanner(System.in);
//        PriorityQueue<Command> ordersQueue = new PriorityQueue<>(Comparator.comparingInt(Command::getPreparationTime));
//        List<String> checkList = new ArrayList<>();
//        int choice = 1;
//        while (choice != 0) {
//            showMenu(menu);
//
//            System.out.println("Wybierz numer dania do zamówienia (0 aby zakończyć):");
//            choice = scanner.nextInt();
//            if (choice >= 1 && choice <= menu.size()) {
//                MenuItem selectedDish = menu.get(choice - 1);
//                checkList.add(selectedDish.getName());
//                Command order = new OrderCommand(chef, selectedDish);
//                ordersQueue.offer(order);
//                System.out.println("Dodano danie " + selectedDish.getName() + " do zamówienia.");
//            } else if (choice != 0) {
//                System.out.println("Nieprawidłowy numer. Wybierz ponownie lub wpisz 0, aby zakończyć.");
//            }
//        }
//        System.out.println("Your order:");
//        checkList.forEach(System.out::println);
//        return ordersQueue;
//    }
//
//    private static void showMenu(List<MenuItem> menu) {
//        System.out.println("Menu:");
//        for (int i = 0; i < menu.size(); i++) {
//            MenuItem item = menu.get(i);
//            System.out.println((i + 1) + ". " + item.getName() + " ($" + item.getPrice() + ")");
//        }
//    }
//
//    private static List<MenuItem> getMenuItems() {
//        MenuItem spaghetti = new MenuItem(ItemType.DISH,"Spaghetti Carbonara", 12.99, 5);
//        MenuItem steak = new MenuItem(ItemType.DISH,"Grilled Steak", 24.99, 8);
//        MenuItem soup = new MenuItem(ItemType.DISH,"Creamy Soup", 6.99, 4);
//        MenuItem pizza = new MenuItem(ItemType.DISH,"Margherita Pizza", 15.99, 10);
//        MenuItem cola = new MenuItem(ItemType.DRINK,"Cola", 3.99, 1);
//        MenuItem water = new MenuItem(ItemType.DRINK,"Water", 1.99, 1);
//
//
//        List<MenuItem> menu = new ArrayList<>();
//        menu.add(spaghetti);
//        menu.add(steak);
//        menu.add(soup);
//        menu.add(pizza);
//        menu.add(cola);
//        menu.add(water);
//        return menu;
//    }
}







