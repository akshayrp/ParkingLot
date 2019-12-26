package com.parkingLot;

import java.util.ArrayList;

public class ParkingLotAvailabilityChecker {
    ArrayList detailsOfCarInSlot;

    public ParkingLotAvailabilityChecker() {
        this.detailsOfCarInSlot = new ArrayList();
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
}
