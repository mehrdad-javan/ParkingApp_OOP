package se.lexicon.model;


/**
 * Represents a vehicle that can be associated with a parking spot reservation.
 */
public class Vehicle {
    private String licensePlate;
    private VehicleType type;
    private Customer customer;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.type = VehicleType.CAR;
    }

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public Vehicle(String licensePlate, VehicleType type, Customer customer) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.customer = customer;
    }

    /**
     * Retrieves the license plate of the vehicle.
     *
     * @return the license plate of the vehicle
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Retrieves the type of the vehicle.
     *
     * @return the type of the vehicle
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * Sets the license plate of the vehicle.
     *
     * @param licensePlate the new license plate to be set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * Sets the type of the vehicle.
     *
     * @param type the new type to be set
     */
    public void setType(VehicleType type) {
        this.type = type;
    }

    /**
     * Generates a description of the vehicle.
     *
     * @return a description of the vehicle including its type and license plate
     */
    public String getDescription() {
        return "This is a " + type.getName() + " with license plate " + licensePlate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    /**
     * Overrides the default toString method to provide a string representation of the Vehicle object.
     *
     * @return a string representation of the Vehicle object
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                '}';
    }

}