package business;

import model.Vehicle;
import service.ConsoleService;
import service.Notification;
import util.Constants;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ServiceFacade {

    private final Notification notificationService = new Notification(new ConsoleService());

    public void maintenanceMessage(Vehicle vehicle) {
        if (ChronoUnit.DAYS.between(vehicle.getLastMaintenance(), LocalDate.now())> Constants.MAX_MAINTENANCE_DAYS){
            notificationService.NotifyUser("Pending maintenance since: " + vehicle.getLastMaintenance());
        }
    }
}
