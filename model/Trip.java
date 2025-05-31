package model;

import java.time.LocalDate;

public class Trip {
    private double distanceTravelled;
    private LocalDate tripDate;
    private Long id;
    private String vehiclePlate;

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }
}
