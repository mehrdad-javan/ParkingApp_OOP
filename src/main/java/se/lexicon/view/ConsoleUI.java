package se.lexicon.view;


import se.lexicon.model.*;

import java.util.List;

public class ConsoleUI implements IConsoleUI {

    @Override
    public MainMenuAction displayMenu() {
        System.out.println("Main Menu:");
        System.out.println("1. Display Parking Spots");
        System.out.println("2. Register");
        System.out.println("3. Reserve Parking Spot");
        System.out.println("4. Display and Vacate");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int operationCode = getNumber();
        return MainMenuAction.getAction(operationCode);
    }

    @Override
    public ParkingSpot parkingSpotPrompt() {
        System.out.print("Enter Area Code: ");
        int areaCode = getNumber();
        System.out.print("Enter Spot Number: ");
        int spotNumber = getNumber();
        return new ParkingSpot(spotNumber, areaCode);
    }

    @Override
    public Reservation reservationPrompt() {
        ParkingSpot parkingSpot = parkingSpotPrompt();
        System.out.print("Enter Number of Hours: ");
        int numberOfHours = getNumber();
        Vehicle vehicle = vehiclePrompt();
        return new Reservation(parkingSpot, numberOfHours, vehicle);
    }

    @Override
    public Customer customerPrompt() {
        System.out.print("Enter Customer Name: ");
        String name = getString();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = getString();
        return new Customer(name, phoneNumber);
    }

    @Override
    public Vehicle vehiclePrompt() {
        System.out.print("Enter Vehicle Plate: ");
        String plate = getString();
        System.out.println("Vehicle Type:");
        VehicleType vehicleType = selectVehicleType();
        return new Vehicle(plate, vehicleType);
    }


    private VehicleType selectVehicleType() {
        for (VehicleType type : VehicleType.values()) {
            System.out.print(type.getCode() + ": " + type.getName() + " " );
        }
        System.out.println();
        int typeNumber = getNumber();
        return VehicleType.getVehicleType(typeNumber);
    }


    @Override
    public void displayCustomerReservation(Customer customer) {
        Reservation reservation = customer.getReservation();
        if (reservation != null) {
            System.out.println("Parking Reservation ID: " + reservation.getId() + " Customer ID:" + customer.getId());
            System.out.println("Parking Spot: " + reservation.getParkingSpot().getSpotNumber() +
                    ", Vehicle Type: " + reservation.getAssociatedVehicle().getType() +
                    ", License Plate: " + reservation.getAssociatedVehicle().getLicensePlate() +
                    ", Start Time: " + reservation.getStartTime() +
                    ", End Time: " + reservation.getEndTime());
        } else {
            System.out.println("There is no reservation for this customer.");
        }
    }


    @Override
    public void displayParkingSpots(List<ParkingSpot> parkingSpots, int areaCode) {
        System.out.println("------------------------");
        int counter = 0;
        for (ParkingSpot parkingSpot : parkingSpots) {
            counter++;
            System.out.print("| ");
            System.out.print(parkingSpot.getSpotNumber() + "  " + (parkingSpot.isOccupied() ? "X" : "\u2713"));
            System.out.print(" |");
            if (counter % 3 == 0) {
                System.out.println();
                System.out.println("------------------------");
            }
        }
        System.out.println("AREA CODE: " + areaCode);
        System.out.println("------------------------");

    }

    @Override
    public void displayRegistration(Customer customer, Vehicle vehicle) {
        System.out.println("Customer Details:");
        System.out.println(customer.getDescription());
        System.out.println("Vehicle License Plate: " + vehicle.getLicensePlate());
    }


}
