package model;

import java.time.LocalDate;

public class PickupTruck extends Vehicle implements HasTractionType {

    boolean fourWheelTraction;
    public PickupTruck(String carPlate, double carryingCapacity, LocalDate lastMaintenance) {
        super(carPlate, carryingCapacity, lastMaintenance);
    }

    @Override
    public boolean hasFourWheelTraction() {
        return false;
    }

    @Override
    public void setFourWheelTraction(boolean fourWheelTraction) throws IllegalArgumentException {

        this.fourWheelTraction = fourWheelTraction;
    }

    @Override
    public double getFuelConsumption() {
        return 10.0;
    }

    @Override
    public double getMaintenanceCost() {
        return 500.0;
    }
    @Override
    public String getPlate() {
        return this.carPlate;
    }
    @Override
    public VehicleType getType() {
        return VehicleType.PICKUP_TRUCK;
    }
}
