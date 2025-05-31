package model;

import util.Validator;

import java.time.LocalDate;

public abstract class Vehicle {
    protected String carPlate;
    protected double carryingCapacity;
    protected LocalDate lastMaintenance;


    public Vehicle() {
        this.carPlate = "";
        this.carryingCapacity = 0.0;
        this.lastMaintenance = LocalDate.now();
    }

    public Vehicle(String carPlate, double carryingCapacity, LocalDate lastMaintenance) throws IllegalArgumentException {
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

    public void setFuelConsumption(double fuelConsumption) throws IllegalArgumentException{
        Validator.validateNegatives(fuelConsumption);
    }

    public void setMaintenanceCost(double maintenanceCost) throws IllegalArgumentException{
       Validator.validateNegatives(maintenanceCost);
    }

    public void setPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public void setLastMaintenance(LocalDate lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public String getPlate(){
        return this.carPlate;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public LocalDate getLastMaintenance() {
        return lastMaintenance;
    }

    public abstract VehicleType getType();

}
