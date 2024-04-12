package se.lexicon.data;

import se.lexicon.model.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationDaoImpl implements ReservationDao {

    private List<Reservation> storage = new ArrayList<>();

    private static ReservationDaoImpl instance;

    private ReservationDaoImpl() {
    }

    public static ReservationDaoImpl getInstance() {
        if (instance == null) {
            instance = new ReservationDaoImpl();
        }
        return instance;
    }

    @Override
    public Reservation create(Reservation reservation) {
        storage.add(reservation);
        return reservation;
    }

    @Override
    public Optional<Reservation> find(String id) {
        for (Reservation reservation : storage) {
            if (reservation.getId().equals(id)) {
                return Optional.of(reservation);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Reservation> findByVehicleLicensePlate(String licensePlate) {
        List<Reservation> reservationsByVehicle = new ArrayList<>();
        for (Reservation reservation : storage) {
            if (reservation.getAssociatedVehicle().getLicensePlate().equals(licensePlate)) {
                reservationsByVehicle.add(reservation);
            }
        }
        return reservationsByVehicle;
    }

    @Override
    public List<Reservation> findByParkingSpotNumber(int spotNumber) {
        List<Reservation> reservationsBySpot = new ArrayList<>();
        for (Reservation reservation : storage) {
            if (reservation.getParkingSpot().getSpotNumber() == spotNumber) {
                reservationsBySpot.add(reservation);
            }
        }
        return reservationsBySpot;
    }
}
