package view;

import business.VehicleFacade;
import exception.EntityNotFoundException;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleManagement {

    public int mainMenu(Scanner scanner) throws IllegalArgumentException {
        try{
            System.out.println("=== Delivery Fleet Management ===");
            System.out.println("Authors: [Miguel Armas, Soledad Buri, Jaime Landazuri, Cael Soto]");
            System.out.println("1. Register Vehicle");
            System.out.println("2. Register Trip");
            System.out.println("3. Update Maintenance date");
            System.out.println("4. Vehicle List");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = Integer.parseInt(scanner.nextLine());
            if (option < 1 || option > 5) {
                throw new IllegalArgumentException("Invalid option");
            }
            return option;
        } catch (InputMismatchException e){
            scanner.nextLine();
            throw new IllegalArgumentException("Invalid input");
        }
    }

    private static Vehicle enterVehicleType(Scanner scanner) throws NumberFormatException {
        System.out.println("Enter vehicle type:");
        System.out.println("1. Truck\n2. Motorcycle\n3. Pickup");
        int vehicleType = Integer.parseInt(scanner.nextLine());
        Vehicle vehicle = null;

        switch (vehicleType) {
            case 1:
                vehicle = new Truck();
                break;
            case 2:
                vehicle = new Motorcycle();
                break;
            case 3:
                vehicle = new PickupTruck();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
        return vehicle;
    }

    public static void enterVehicleData(Scanner scanner, Vehicle vehicle) throws DateTimeParseException, NumberFormatException {
        System.out.println("Enter vehicle plate:");
        String plate = scanner.nextLine();
        vehicle.setPlate(plate);

        System.out.println("Enter carrying capacity (Kg):");
        double carryingCapacity = Double.parseDouble(scanner.nextLine());
        vehicle.setCarryingCapacity(carryingCapacity);

        System.out.println("Enter last maintenance date (YYYY-MM-DD):");
        try {
            LocalDate lastMaintenanceDate = LocalDate.parse(scanner.nextLine());
            vehicle.setLastMaintenance(lastMaintenanceDate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    public static void enterVehicleDetails(Truck truck, Scanner scanner){
        System.out.println("Enter axle count for the Truck:");
        int axleCount = Integer.parseInt(scanner.nextLine());
        try {
            truck.setAxleCount(axleCount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting axle count: " + e.getMessage());
        }
    }

    public static void enterVehicleDetails(Motorcycle motorcycle, Scanner scanner){
        System.out.print("Enter engine displacement for the Motorcycle: ");
        double engineDisplacement = Double.parseDouble(scanner.nextLine());
        try {
            motorcycle.setEngineDisplacement(engineDisplacement);
        } catch (IllegalArgumentException e) {
            System.out.println("Error setting engine displacement: " + e.getMessage());
        }
    }

    public static void enterVehicleDetails(PickupTruck pickup, Scanner scanner){
        System.out.println("Has 4x4 traction? (y/n):");
        String tractionInput = scanner.nextLine();
        boolean has4x4Traction = tractionInput.equalsIgnoreCase("y");
        pickup.setFourWheelTraction(has4x4Traction);
    }

    public static Vehicle handleMenuOption(Scanner scanner, VehicleFacade facade){
        Vehicle vehicle = null;
        try {
            int option = new VehicleManagement().mainMenu(scanner);
            switch (option) {
                case 1:
                    vehicle = enterVehicleType(scanner);
                    if (vehicle != null) {
                        enterVehicleData(scanner, vehicle);
                        addExtraParameters(vehicle, scanner);
                        facade.create(vehicle);
                        System.out.println("Vehicle registered successfully: " + vehicle.getPlate());
                    }
                    break;
                case 2:

                    break;
                case 3:
                    // Update maintenance date logic here
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        } catch (IllegalArgumentException | DateTimeParseException | EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return vehicle;
    }

    private static void addExtraParameters(Vehicle vehicle, Scanner scanner) {
        switch (vehicle.getType()){
            case TRUCK:
                enterVehicleDetails((Truck) vehicle, scanner);
                break;
            case MOTORCYCLE:
                enterVehicleDetails((Motorcycle) vehicle, scanner);
                break;
            case PICKUP:
                enterVehicleDetails((PickupTruck) vehicle, scanner);
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleFacade facade = new VehicleFacade();
        handleMenuOption(sc, facade);

        System.out.println("Vehicle Management System is running...");
    }

}
