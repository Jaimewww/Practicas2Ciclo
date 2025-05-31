package model;

import util.Validator;

import java.time.LocalDate;

public class Motorcycle extends Vehicle implements HasEngineDisplacement{
    private double engineDisplacement;

    private static int motorcycleCount = 0;
    private static double fuelConsumption = 0.0;
    private static double maintenanceCost = 0.0;

    public Motorcycle() {
    }

    public Motorcycle(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        super(carPlate, carryingCapacity, lastMaintenance);
        motorcycleCount++;
    }

    @Override
    public double getEngineDisplacement() {
        return this.engineDisplacement;
    }

    @Override
    public void setEngineDisplacement(double engineDisplacement) throws IllegalArgumentException {
        Validator.validateNegatives(engineDisplacement);
        this.engineDisplacement = engineDisplacement;
    }
    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

    public void setFuelConsumption(double fuelConsumption) throws IllegalArgumentException {
        Motorcycle.fuelConsumption = fuelConsumption;
    }

    public void setMaintenanceCost(double maintenanceCost) throws IllegalArgumentException {
        Motorcycle.maintenanceCost = maintenanceCost;
    }

    public int getMotorcycleCount() {
        return motorcycleCount;
    }
}
