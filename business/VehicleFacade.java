package business;

import data.VehicleRepository;
import exception.EntityNotFoundException;
import model.Vehicle;

public class VehicleFacade {
    private final VehicleRepository repo = new VehicleRepository();

    public Vehicle create(Vehicle vehicle) throws EntityNotFoundException {
        try{
            repo.find(vehicle.getPlate());
        } catch (EntityNotFoundException e) {
            return repo.save(vehicle);
        }
        throw new EntityNotFoundException("Vehicle with plate " + vehicle.getPlate() + " already exists.");
    }
}
