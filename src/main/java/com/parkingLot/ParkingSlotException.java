package com.parkingLot;

public class ParkingSlotException extends Exception {
    public enum ExceptionType {
        SLOT_IS_OCCUPIED, ALL_SLOTS_FULL
    }

    ExceptionType type;

    public ParkingSlotException( ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
