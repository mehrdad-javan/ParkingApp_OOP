package se.lexicon.data;

import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {

    private List<ParkingSpot> storage = new ArrayList<>();

    private static ParkingSpotDaoImpl instance;

    private ParkingSpotDaoImpl() {
    }

    public static ParkingSpotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingSpotDaoImpl();
        }
        return instance;
    }

    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        storage.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> find(int spotNumber, int areaCode) {
        for (ParkingSpot parkingSpot : storage) {
            if (parkingSpot.getAreaCode() == areaCode && parkingSpot.getSpotNumber() == spotNumber) {
                return Optional.of(parkingSpot);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<ParkingSpot> findByAreaCode(int areaCode) {
        List<ParkingSpot> parkingSpotsByAreaCode = new ArrayList<>();

        for (ParkingSpot spot : storage) {
            if (spot.getAreaCode() == areaCode) {
                parkingSpotsByAreaCode.add(spot);
            }
        }

        return parkingSpotsByAreaCode;
    }

    @Override
    public void occupyParkingSpot(int spotNumber, int areaCode) {
        for (ParkingSpot spot : storage) {
            if (spot.getAreaCode() == areaCode && spot.getSpotNumber() == spotNumber) {
                spot.occupy();
                break;
            }
        }
    }

    @Override
    public void vacateParkingSpot(int spotNumber, int areaCode) {
        for (ParkingSpot spot : storage) {
            if (spot.getAreaCode() == areaCode && spot.getSpotNumber() == spotNumber) {
                spot.vacate();
                break;
            }
        }
    }

}
