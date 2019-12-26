package com.parkingLot;

public enum ParkingType {
    HANDICAP(1,4),SMALL_VEHICLE(5,7),LARGE_VEHICLE(8,10);

    public final int startingSlot;
    public final int endingSlot;

    ParkingType(int startingSlot,int endingSlot) {
    this.startingSlot = startingSlot;
    this.endingSlot = endingSlot;
    }
}
