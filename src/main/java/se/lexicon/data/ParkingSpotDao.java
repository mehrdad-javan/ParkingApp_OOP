package se.lexicon.data;


import se.lexicon.model.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface ParkingSpotDao {

    ParkingSpot create(ParkingSpot parkingSpot);

    Optional<ParkingSpot> find(int spotNumber, int areaCode);

    List<ParkingSpot> findByAreaCode(int areaCode);

    void occupyParkingSpot(int spotNumber, int areaCode);

    void vacateParkingSpot(int spotNumber, int areaCode);
}
