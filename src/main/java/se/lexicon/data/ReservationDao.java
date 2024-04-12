package se.lexicon.data;


import se.lexicon.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationDao {

    Reservation create(Reservation reservation);

    Optional<Reservation> find(String id);

    List<Reservation> findByVehicleLicensePlate(String licensePlate);

    List<Reservation> findByParkingSpotNumber(int spotNumber);


}
