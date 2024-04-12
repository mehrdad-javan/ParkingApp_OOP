package se.lexicon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {

    @Test
    public void testGetLicensePlate() {
        Vehicle vehicle = new Vehicle("ABC123");
        assertEquals("ABC123", vehicle.getLicensePlate());
    }

    @Test
    public void testGetType() {
        Vehicle vehicle = new Vehicle("XYZ789", VehicleType.MOTORCYCLE);
        assertEquals(VehicleType.MOTORCYCLE, vehicle.getType());
    }

    @Test
    public void testSetLicensePlate() {
        Vehicle vehicle = new Vehicle("DEF456");
        vehicle.setLicensePlate("GHI789");
        assertEquals("GHI789", vehicle.getLicensePlate());
    }

    @Test
    public void testSetType() {
        Vehicle vehicle = new Vehicle("JKL012", VehicleType.TRUCK);
        vehicle.setType(VehicleType.VAN);
        assertEquals(VehicleType.VAN, vehicle.getType());
    }

    @Test
    public void testGetDescription() {
        Vehicle vehicle = new Vehicle("MNO345", VehicleType.CAR);
        assertEquals("This is a Car with license plate MNO345", vehicle.getDescription());
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        Vehicle vehicle = new Vehicle("PQR678", VehicleType.CAR, customer);
        assertEquals(customer, vehicle.getCustomer());
    }

    @Test
    public void testToString() {
        Vehicle vehicle = new Vehicle("STU901", VehicleType.CAR);
        assertEquals("Vehicle{licensePlate='STU901', type=CAR}", vehicle.toString());
    }
}