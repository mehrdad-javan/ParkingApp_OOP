package se.lexicon.model;

public enum VehicleType {
    CAR(1, "Car"),
    MOTORCYCLE(2, "Motorcycle"),
    TRUCK(3, "Truck"),
    VAN(4, "Van"),
    ELECTRIC(5, "Electric Vehicle"),
    OTHER(6, "Other");

    private final String name;
    private final int code;

    VehicleType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }


    public static VehicleType getVehicleType(int code) {
        for (VehicleType type : VehicleType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid vehicle type code: " + code);
    }
}