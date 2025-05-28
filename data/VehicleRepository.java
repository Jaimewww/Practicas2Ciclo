package data;

import model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VehicleRepository {
    private static final Map<String, Vehicle> tableVehicleDB = new TreeMap<>();

    public VehicleRepository() {
    }

    public Vehicle save(Vehicle vehicle) throws IllegalArgumentException {
        tableVehicleDB.put(vehicle.getPlate(), vehicle);
        return tableVehicleDB.get(vehicle.getPlate());
    }

    public Vehicle findByPlate(String plate) throws IllegalArgumentException {
        Vehicle vehicle = tableVehicleDB.get(plate);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle not found with plate: " + plate);
        }
        return vehicle;
    }

    public List<Vehicle> findAll() {
        return new ArrayList<>(tableVehicleDB.values());
    }
}
