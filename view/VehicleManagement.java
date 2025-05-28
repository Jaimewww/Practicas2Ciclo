package view;

import data.VehicleRepository;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class VehicleManagement {
    private final VehicleRepository vehicleRepository = new VehicleRepository();

    public Vehicle createVehicle(Scanner scanner) {
        Vehicle vehicle = null;
        System.out.println("Enter vehicle plate:");
        String plate = scanner.nextLine();
        System.out.println("Enter carrying capacity (Kg):");
        double carryingCapacity = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter last maintenance date (YYYY-MM-DD):");
        try{
            LocalDate lastMaintenanceDate = LocalDate.parse(scanner.nextLine());
        } catch(DateTimeParseException e){
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }


        System.out.println("Enter vehicle type:");
        System.out.println("1. Truck\n2. Motorcycle\n3. Pickup");
        int vehicleType = Integer.parseInt(scanner.nextLine());
        switch (vehicleType) {
            case 1:
                // Handle Truck creation
                System.out.println("Creating a Truck...");
                Truck truck = new model.Truck(plate, carryingCapacity, LocalDate.now());
                System.out.println("Enter axle count for the Truck:");
                int axleCount = Integer.parseInt(scanner.nextLine());
                try {
                    truck.setAxleCount(axleCount);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error setting axle count: " + e.getMessage());
                }
                vehicleRepository.save(truck);
                System.out.println("Truck created successfully with plate: " + truck.getPlate());
                break;
            case 2:
                // Handle Motorcycle creation
                System.out.println("Creating a Motorcycle...");
                Motorcycle motorcycle = new model.Motorcycle(plate, carryingCapacity, LocalDate.now());
                System.out.print("Enter engine displacement for the Motorcycle: ");
                double engineDisplacement = Double.parseDouble(scanner.nextLine());
                try {
                    motorcycle.setEngineDisplacement(engineDisplacement);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error setting engine displacement: " + e.getMessage());
                }
                vehicleRepository.save(motorcycle);
                System.out.println("Motorcycle created successfully with plate: " + motorcycle.getPlate());
                break;
            case 3:
                // Handle Pickup creation
                System.out.println("Creating a Pickup...");
                PickupTruck pickup = new PickupTruck(plate, carryingCapacity, LocalDate.now());
                System.out.println("Has 4x4 traction? (y/n):");
                String tractionInput = scanner.nextLine();
                boolean has4x4Traction = tractionInput.equalsIgnoreCase("y");
                pickup.setFourWheelTraction(has4x4Traction);
                vehicleRepository.save(pickup);
                System.out.println("Pickup created successfully with plate: " + pickup.getPlate());
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }



    public static void main(String[] args) {
        VehicleManagement vehicleManagement = new VehicleManagement();
        vehicleManagement.createVehicle(new Scanner(System.in));
        System.out.println("Vehicle Management System is running...");
    }

}
