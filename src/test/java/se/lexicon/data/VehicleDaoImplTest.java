package se.lexicon.data;

// Importing necessary classes and annotations from JUnit and custom packages

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;
import se.lexicon.model.Vehicle;
import se.lexicon.model.VehicleType;

import static org.junit.jupiter.api.Assertions.*;


public class VehicleDaoImplTest {

    private VehicleDao testObject; // Declaring VehicleDao instance for testing

    /**
     * Setup method executed before each test method.
     */
    @BeforeEach
    public void setUp() {
        testObject = VehicleDaoImpl.getInstance(); // Initializing VehicleDao instance
    }

    @Test
    public void testCreate() {
        Vehicle vehicle = new Vehicle("ABC123", VehicleType.CAR, new Customer(1, "John Doe", "1234567890"));

        // Test creating a new vehicle
        assertNotNull(testObject.create(vehicle));

        // Test updating an existing vehicle
        vehicle.setType(VehicleType.TRUCK);
        assertEquals(vehicle, testObject.create(vehicle));
    }

    @Test
    public void testFind() {
        Vehicle vehicle = new Vehicle("XYZ789", VehicleType.MOTORCYCLE, new Customer(2, "Jane Smith", "9876543210"));
        testObject.create(vehicle);

        // Test finding an existing vehicle
        assertTrue(testObject.find("XYZ789", 2).isPresent());

        // Test finding a non-existing vehicle
        assertFalse(testObject.find("DEF456", 3).isPresent());
    }

    @Test
    public void testRemove() {
        Vehicle vehicle = new Vehicle("DEF456", VehicleType.CAR, new Customer(3, "Alice Johnson", "5555555555"));
        testObject.create(vehicle);

        // Test removing an existing vehicle
        assertTrue(testObject.remove("DEF456", 3));

        // Test removing a non-existing vehicle
        assertFalse(testObject.remove("GHI789", 4));
    }

    @Test
    public void testUpdate() {
        Vehicle vehicle = new Vehicle("GHI789", VehicleType.TRUCK, new Customer(4, "Bob Brown", "6666666666"));
        testObject.create(vehicle);

        // Test updating an existing vehicle
        vehicle.setType(VehicleType.VAN);
        vehicle.setCustomer(new Customer(4, "Bob Brown", "7777777777"));
        testObject.update(vehicle);

        assertEquals(VehicleType.VAN, testObject.find("GHI789", 4).get().getType());
    }

    @Test
    public void testFindByCustomerId() {
        Vehicle vehicle1 = new Vehicle("JKL012", VehicleType.TRUCK, new Customer(5, "Lisa White", "8888888888"));
        Vehicle vehicle2 = new Vehicle("MNO345", VehicleType.CAR, new Customer(5, "Lisa White", "8888888888"));
        testObject.create(vehicle1);
        testObject.create(vehicle2);

        // Test finding vehicles by customer ID
        assertEquals(2, testObject.findByCustomerId(5).size());
    }


}