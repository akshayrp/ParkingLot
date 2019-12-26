package com.parkingLot;
public class ParkingLotSystem {
    public final int numberOfSlotLines = 10;
    public final int numberOfSlotPerLine = 10;

    CarDao[][] slot;

    public ParkingLotSystem() {
        this.slot = new CarDao[numberOfSlotLines][numberOfSlotPerLine];
    }

    public Integer[] giveEmptySlot(int firstSlotNumberOfParkingType, int lastSlotNumberOfParkingType) throws ParkingSlotException {
        for (int line = 1; line <= numberOfSlotLines; line++) {
            for (int slot = firstSlotNumberOfParkingType; slot <= lastSlotNumberOfParkingType; slot++) {
                if (this.slot[line][slot] == null) {
                    Integer[] emptySlot = {line, slot};
                    return emptySlot;
                }
            }
        }
        throw new ParkingSlotException(ParkingSlotException.ExceptionType.ALL_SLOTS_FULL,"all slots full,cannot park");
    }

    public void parkCar(Integer[] emptySlot, CarDao carDetails) {
        slot[emptySlot[0]][emptySlot[1]] = carDetails;
    }
}
