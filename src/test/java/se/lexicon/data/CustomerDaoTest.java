package se.lexicon.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoTest {
    CustomerDaoImpl customerDao;
    Customer createdCustomer;

    @BeforeEach
    public void setup() {
        customerDao = CustomerDaoImpl.getInstance();
        createdCustomer = customerDao.create(new Customer("Mehrdad Javan", "1234567890"));


    }

    @Test
    public void testCreate() {
        Customer customer = new Customer("John Smith", "1234567890");
        // Test creating a new customer
        assertNotNull(customerDao.create(customer));
    }

    @Test
    public void testFind() {

        // Test finding an existing customer
        assertTrue(customerDao.find(createdCustomer.getId()).isPresent());

        // Test finding a non-existing customer
        assertFalse(customerDao.find(11).isPresent());
    }

    @Test
    public void testRemove() {
        Customer customer = new Customer("Alice Johnson", "5555555555");
        customer = customerDao.create(customer);

        // Test removing an existing customer
        assertTrue(customerDao.remove(customer.getId()));

        // Test removing a non-existing customer
        assertFalse(customerDao.remove(44));
    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer("Bob Brown", "6666666666");
        customer = customerDao.create(customer);

        // Test updating an existing customer
        customer.setName("Updated Name");
        customer.setPhoneNumber("7777777777");
        customerDao.update(customer);

        assertEquals("Updated Name", customerDao.find(customer.getId()).get().getName());
        assertEquals("7777777777", customerDao.find(customer.getId()).get().getPhoneNumber());
        assertNull(customerDao.find(customer.getId()).get().getReservation());
    }

    @Test
    public void testFindAll() {
        customerDao.create(new Customer("Test 1", "1111111111"));
        customerDao.create(new Customer("Test 2", "2222222222"));

        // Test finding all customers
        assertEquals(3, customerDao.findAll().size());
    }
}