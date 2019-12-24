package com.parkingLot;

public class ParkingLotSystem {
    CarDao[][] slot;

    public ParkingLotSystem() {
        this.slot = new CarDao[10][10];
    }

    public Integer[] giveEmptySlot() {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (slot[i][j] == null) {
                    Integer[] emptySlot = {i, j};
                    return emptySlot;
                }
            }
        }
        return null;
    }
}
