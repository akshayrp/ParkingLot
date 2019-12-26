package com.parkingLot;

import java.util.ArrayList;

public class ParkingLotSystem {
    ArrayList detailsOfCarInSlot;

    public ParkingLotSystem() {
        this.detailsOfCarInSlot = new ArrayList<>();
        initializeEmptySlots();
    }

    private void initializeEmptySlots() {
        for (int slots = 0; slots < 5; slots++) {
            detailsOfCarInSlot.add(null);
        }
    }

    public int giveEmptySlot() throws ParkingSlotException {
        for (int slotNumber = 1; slotNumber <= 5; slotNumber++) {
            if (detailsOfCarInSlot.get(slotNumber) == null) {
                return slotNumber;
            }
        }
        throw new ParkingSlotException(ParkingSlotException.ExceptionType.ALL_SLOTS_FULL, "all slots full,cannot park");
    }

    public boolean parkCar(int slotNumber, CarDao carDetails) throws ParkingSlotException {
        if (detailsOfCarInSlot.get(slotNumber) == null) {
            detailsOfCarInSlot.add(slotNumber, carDetails);
            return true;
        }
        throw new ParkingSlotException(ParkingSlotException.ExceptionType.SLOT_IS_OCCUPIED, "This Slot is occupied !! " +
                "Try Another one");
    }

    public boolean unParkCar(Integer slotNumber) {
        if (detailsOfCarInSlot.get(slotNumber) != null) {
            detailsOfCarInSlot.remove(slotNumber);
            return true;
        }
        return false;
    }
}
