package se.lexicon.data;


import se.lexicon.model.Vehicle;

import java.util.Collection;
import java.util.Optional;


public interface VehicleDao {

    Optional<Vehicle> find(String licensePlate, int customerId);

    Vehicle create(Vehicle vehicle);

    boolean remove(String licensePlate, int customerId);

    void update(Vehicle vehicle);

    Collection<Vehicle> findByCustomerId(int customerId);

}
