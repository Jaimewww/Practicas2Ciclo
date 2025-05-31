package model;

import java.time.LocalDate;

public class PickupTruck extends Vehicle implements HasTractionType {
    boolean fourWheelTraction;

    private static int pickUpTruckCount = 0;
    private static double fuelConsumption = 0.0;
    private static double maintenanceCost = 0.0;

    public PickupTruck() {
    }

    public PickupTruck(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        super(carPlate, carryingCapacity, lastMaintenance);
    }

    @Override
    public boolean hasFourWheelTraction() {
        return fourWheelTraction;
    }

    @Override
    public void setFourWheelTraction(boolean fourWheelTraction) throws IllegalArgumentException {
        this.fourWheelTraction = fourWheelTraction;
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }
    @Override
    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setFuelConsumption(double fuelConsumption) throws IllegalArgumentException {
        PickupTruck.fuelConsumption = fuelConsumption;
    }

    public void setMaintenanceCost(double maintenanceCost) throws IllegalArgumentException {
        PickupTruck.maintenanceCost = maintenanceCost;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.PICKUP;
    }


}
