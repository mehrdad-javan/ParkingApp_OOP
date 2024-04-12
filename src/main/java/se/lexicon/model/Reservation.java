package se.lexicon.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

/**
 * Represents a reservation made by a customer for a parking spot.
 */
public class Reservation {
    private String id;
    private ParkingSpot parkingSpot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Vehicle associatedVehicle;

    public Reservation(ParkingSpot parkingSpot, int hours, Vehicle associatedVehicle) {
        this.parkingSpot = parkingSpot;
        this.startTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.endTime = this.startTime.plusHours(hours);
        this.associatedVehicle = associatedVehicle;
    }

    public Reservation(String id, ParkingSpot parkingSpot, int hours, Vehicle associatedVehicle) {
        this(parkingSpot, hours, associatedVehicle);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Vehicle getAssociatedVehicle() {
        return associatedVehicle;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void extendTime(int hours) {
        this.endTime = endTime.plusHours(hours);
    }

    public void extendTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setAssociatedVehicle(Vehicle associatedVehicle) {
        this.associatedVehicle = associatedVehicle;
    }

    public void reserve() {
        if (parkingSpot == null) throw new IllegalArgumentException("Parking Spot should not be null.");
        if (parkingSpot.isOccupied()) throw new IllegalArgumentException("Parking spot is already occupied!");
        this.id = UUID.randomUUID().toString();
        parkingSpot.occupy();
        associatedVehicle.getCustomer().setReservation(this);
    }

    public void close() {
        parkingSpot.vacate();
        associatedVehicle.getCustomer().setReservation(null);
    }

    public String getDescription() {
        return new StringBuilder().append("Reservation ID: ").append(id)
                .append("\nParking Spot: ").append(parkingSpot.getSpotNumber())
                .append("\nStart Time: ").append(startTime)
                .append("\nEnd Time: ").append(endTime)
                .append("\nAssociated Vehicle: ").append(associatedVehicle.getLicensePlate())
                .toString();
    }


}