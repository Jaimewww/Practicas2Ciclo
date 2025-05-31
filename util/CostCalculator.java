package util;

import model.Trip;
import model.Vehicle;

public class CostCalculator {
    public static double calculateTripCost(Vehicle vehicle, Trip trip) {
        return (trip.getDistanceTravelled() * vehicle.getFuelConsumption()
                * Constants.PRICE_PER_LITER)+vehicle.getMaintenanceCost();
    }
}
