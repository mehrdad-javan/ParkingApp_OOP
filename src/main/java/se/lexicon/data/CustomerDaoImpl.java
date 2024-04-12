package se.lexicon.data;

import se.lexicon.data.sequencer.CustomerSequencer;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> storage = new ArrayList<>();

    private static CustomerDaoImpl instance;

    private CustomerDaoImpl() {
    }

    public static CustomerDaoImpl getInstance() {
        if (instance == null) {
            instance = new CustomerDaoImpl();
        }
        return instance;
    }

    @Override
    public Customer create(Customer data) {
        data.setId(CustomerSequencer.nextId());
        storage.add(data);
        return data;
    }

    @Override
    public Optional<Customer> find(int id) {
        for (Customer element : storage) {
            if (element.getId() == id) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(int id) {
        Optional<Customer> customerOptional = find(id);
        if (!customerOptional.isPresent()) return false;
        else {
            storage.remove(customerOptional.get());
            return true;
        }
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Customer customer) {
        for (Customer storedCustomer : storage) {
            if (storedCustomer.getId() == customer.getId()) {
                // Update the existing customer with the new data
                storedCustomer.setName(customer.getName());
                storedCustomer.setPhoneNumber(customer.getPhoneNumber());
                storedCustomer.setReservation(customer.getReservation());
                // Exit the loop after updating the customer
                break;
            }
        }
    }
}
