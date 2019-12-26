package com.parkingLot;

public enum ParkingType {
    HANDICAP(1),VIP(5),NORMAL(8);

    public final int startingSlot;
    ParkingType(int startingSlot) {
    this.startingSlot = startingSlot;
    }
}
