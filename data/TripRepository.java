package data;

import exception.EntityNotFoundException;
import model.Trip;
import model.Vehicle;

import java.util.Map;
import java.util.TreeMap;

public class TripRepository {
    private final Map<Long, Trip> trips = new TreeMap<>();

    public Trip save(Vehicle vehicle, Trip trip) throws IllegalArgumentException {
        if (trip == null) {
            throw new IllegalArgumentException("Trip cannot be null.");
        }
        long id = trips.size() + 1; // Simple ID generation
        trip.setId(id);
        trip.setVehiclePlate(vehicle.getPlate());
        trips.put(id, trip);
        return trip;
    }

    public Trip find(Long id) throws IllegalArgumentException {
        Trip trip = trips.get(id);
        if (trip == null) {
            throw new IllegalArgumentException("Trip not found with ID: " + id);
        }
        return trip;
    }

    public Trip find(String plate) throws IllegalArgumentException, EntityNotFoundException {
        for (Trip trip : trips.values()) {
            if (trip.getVehiclePlate().equals(plate)) {
                return trip;
            }
        }
        throw new EntityNotFoundException("Trip not found with plate: " + plate);

    }


}
