package org.example.exercises.exercises;

public class Phone extends Device {
    private String name;

    public Phone(String name, String brand) {
        super(brand); //wywolanie konstruktora klasy nadrzednej
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + getBrandName() + '\'' +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public void sendMassage(){
        System.out.println("Sending sms");
    }
}
