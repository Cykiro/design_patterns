package org.example.exercises.exercises;

public class Device {
    private String brandName;

    public Device(String name) {
        brandName = name;
    }
    public Device() {
    }
    public String getBrandName() {
        return brandName;
    }
    public void sendMassage(){
        System.out.println("Unrecognized");
    }
    @Override
    public String toString() {
        return brandName;
    }


}
