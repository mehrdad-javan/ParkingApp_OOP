package se.lexicon.model;


/**
 * Represents a customer who rents parking spots.
 */
public class Customer {
    private int id;
    private String name;
    private String phoneNumber;
    private Reservation reservation;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Customer: ").append(id).append(", Name: ").append(name).append(", Phone Number: ").append(phoneNumber);
        if (reservation != null) {
            description.append(", Reservation: ").append(reservation);
        }
        return description.toString();
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", phoneNumber='" + phoneNumber + '\'' + '}';
    }
}