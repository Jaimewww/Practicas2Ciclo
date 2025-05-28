package model;

import java.time.LocalDate;

public class Motorcycle extends Vehicle implements HasEngineDisplacement{
    private double engineDisplacement;
    public Motorcycle(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        super(carPlate, carryingCapacity, lastMaintenance);
    }

    @Override
    public double getEngineDisplacement() {
        return this.engineDisplacement;
    }

    @Override
    public void setEngineDisplacement(double engineDisplacement) throws IllegalArgumentException {
        if(engineDisplacement < 0) {
            throw new IllegalArgumentException("Engine displacement cannot be negative.");
        }
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    public double getFuelConsumption() {
        return 3.5;
    }

    @Override
    public double getMaintenanceCost() {
        return 200.0;
    }

    @Override
    public String getPlate() {
        return this.carPlate;
    }
    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }
}
