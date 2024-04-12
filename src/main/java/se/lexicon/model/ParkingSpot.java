package se.lexicon.model;

/**
 * Represents a parking spot within a parking lot.
 */
public class ParkingSpot {
    private int spotNumber;
    private boolean occupied;
    private int areaCode;

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        //this.isOccupied = false;
    }

    public ParkingSpot(int spotNumber, int areaCode) {
        this.spotNumber = spotNumber;
        this.areaCode = areaCode;
    }
    public ParkingSpot(int spotNumber, boolean occupied, int areaCode) {
        this.spotNumber = spotNumber;
        this.areaCode = areaCode;
        this.occupied = occupied;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }


    public void occupy() {
        occupied = true;
    }

    public void vacate() {
        occupied = false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", occupied=" + occupied +
                ", areaCode=" + areaCode +
                '}';
    }
}