package model;

import util.Validator;

import java.time.LocalDate;

public class Truck extends Vehicle implements HasAxleCount {
    private int axleCount;

    private static int truckCount = 0;
    private static double fuelConsumption = 0.0;
    private static double maintenanceCost = 0.0;

    public Truck() {
    }

    public Truck(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        super(carPlate, carryingCapacity, lastMaintenance);
    }

    @Override
    public int getAxleCount() {
        return this.axleCount;
    }

    @Override
    public void setAxleCount(int axleCount) throws IllegalArgumentException {
        Validator.validateNegatives(axleCount);
        this.axleCount=axleCount;
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setFuelConsumption(double fuelConsumption){
        Truck.fuelConsumption = fuelConsumption;
    }

    public void setMaintenanceCost(double maintenanceCost){
        Truck.maintenanceCost = maintenanceCost;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
