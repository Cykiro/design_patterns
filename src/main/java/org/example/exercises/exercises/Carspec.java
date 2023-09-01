package org.example.exercises.exercises;

public class Carspec extends Car{
    private String productionYears;
    private String engineSize;
    private int maximumPower;
    private int length;
    private int fuelConsumption;

    public Carspec() {
    }

    public Carspec(String brand, String model, String productionYears, String engineSize, int maximumPower, int length, int fuelConsumption) {
        super(brand, model);
        this.productionYears = productionYears;
        this.engineSize = engineSize;
        this.maximumPower = maximumPower;
        this.length = length;
        this.fuelConsumption = fuelConsumption;
    }

    public void setProductionYears(String productionYears) {
        this.productionYears = productionYears;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public void setMaximumPower(int maximumPower) {
        this.maximumPower = maximumPower;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    @Override
    public String whatIsThis() {
        return "Carspec";
    }
}
