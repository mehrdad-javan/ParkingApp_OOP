package se.lexicon.view;

import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Reservation;
import se.lexicon.model.Vehicle;

import java.util.List;
import java.util.Scanner;


public interface IConsoleUI {

    MainMenuAction displayMenu();

    default int getNumber() {
        return new Scanner(System.in).nextInt();
    }

    default String getString() {
        return new Scanner(System.in).nextLine();
    }

    ParkingSpot parkingSpotPrompt();

    Vehicle vehiclePrompt();

    Customer customerPrompt();

    Reservation reservationPrompt();

    void displayCustomerReservation(Customer customer);

    void displayParkingSpots(List<ParkingSpot> parkingSpots, int areaCode);

    void displayRegistration(Customer customer, Vehicle vehicle);

    default void displayMessage(String msg) {
        System.out.println(msg);
    }


    // ANSI escape codes for color formatting
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLUE = "\u001B[34m";

    default void displaySuccessMessage(String msg) {
        System.out.println(ANSI_BLUE + msg + ANSI_RESET);
    }

    default void displayErrorMessage(String msg) {
        System.out.println(ANSI_RED + msg + ANSI_RESET);
    }
}
