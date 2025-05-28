package model;

import java.time.LocalDate;

public class Truck extends Vehicle implements HasAxleCount {
    private int axleCount;
    public Truck(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        super(carPlate, carryingCapacity, lastMaintenance);
    }

    @Override
    public int getAxleCount() {
        return this.axleCount;
    }

    @Override
    public void setAxleCount(int axleCount) throws IllegalArgumentException {
        if(axleCount < 0) {
            throw new IllegalArgumentException("Axle Count cannot be negative.");
        }
        this.axleCount=axleCount;
    }

    @Override
    public double getFuelConsumption() {
        return 15.0;
    }

    @Override
    public double getMaintenanceCost() {
        return 1000.0;
    }

    @Override
    public String getPlate() {
        return this.carPlate;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
