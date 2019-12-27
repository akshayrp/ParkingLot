package com.parkingLot;

import java.util.ArrayList;

public class CarParkingManager {
    ArrayList detailsOfCarInSlot;

    public CarParkingManager() {
        this.detailsOfCarInSlot = new ArrayList();
        initializeEmptySlots();
    }

    public int giveEmptySlot() throws ParkingSlotException {
        for (int slotNumber = 1; slotNumber <= 5; slotNumber++) {
            if (detailsOfCarInSlot.get(slotNumber) == null) {
                return slotNumber;
            }
        }
        throw new ParkingSlotException(ParkingSlotException.ExceptionType.ALL_SLOTS_FULL, "all slots full,cannot park");
    }

    public boolean parkCar(int slotNumber, CarDao carDetails) {
            addAndRemoveCarDetails(slotNumber,carDetails);
            return true;
    }

    public boolean unParkCar(Integer slotNumber, CarDao carDetails) {
        if (detailsOfCarInSlot.get(slotNumber) != null) {
            addAndRemoveCarDetails(slotNumber, null);
            return true;
        }
        return false;
    }

    private void addAndRemoveCarDetails(int slotNumber, CarDao carDetails) {
        detailsOfCarInSlot.remove(carDetails);
        detailsOfCarInSlot.add(slotNumber, carDetails);
    }

    private void initializeEmptySlots() {
        for (int slots = 0; slots < 5; slots++) {
            detailsOfCarInSlot.add(null);
        }
    }
}
