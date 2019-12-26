package com.parkingLot;

public class ParkingLotSystem {
    CarDao[][] slot;

    public ParkingLotSystem() {
        this.slot = new CarDao[10][10];
    }

    public Integer[] giveEmptySlot(int firstSlotNumberOfParkingType) {
        for (int line = 1; line <= 10; line++) {
            for (int slot = firstSlotNumberOfParkingType; slot <= 10; slot++) {
                if (this.slot[line][slot] == null) {
                    Integer[] emptySlot = {line, slot};
                    return emptySlot;
                }
            }
        }
        return null;
    }

    public void parkCar(Integer[] emptySlot, CarDao carDetails) {
        slot[emptySlot[0]][emptySlot[1]] = carDetails;
    }
}
