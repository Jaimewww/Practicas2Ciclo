package model;

import java.time.LocalDate;

public abstract class Vehicle {
    String carPlate;
    double carryingCapacity;
    LocalDate lastMaintenance;

    public Vehicle(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        if(carPlate == null || carPlate.isEmpty()) {
            throw new IllegalArgumentException("Car plate cannot be null or empty.");
        }
        this.carPlate = carPlate;
        if(carryingCapacity < 0) {
            throw new IllegalArgumentException("Carrying capacity cannot be negative.");
        }
        this.carryingCapacity = carryingCapacity;
        if(lastMaintenance == null) {
            throw new IllegalArgumentException("Last maintenance date cannot be null.");
        }
        this.lastMaintenance = lastMaintenance;
    }

    public abstract double getFuelConsumption();
    public abstract double getMaintenanceCost();
    public abstract String getPlate();
    public abstract VehicleType getType();
}
