package com.parkingLot;

public class ParkingLotSystem {
    ParkingLotAvailabilityChecker availabilityChecker;

    public ParkingLotSystem() {
        this.availabilityChecker = new ParkingLotAvailabilityChecker();
    }

    public boolean parkCar(int slotNumber, CarDao carDetails) throws ParkingSlotException {
        if (availabilityChecker.detailsOfCarInSlot.get(slotNumber) == null) {
        addAndRemoveCarDetails(slotNumber, carDetails);
        return true;
        }
        throw new ParkingSlotException(ParkingSlotException.ExceptionType.SLOT_IS_OCCUPIED, "This Slot is occupied !! " +
                "Try Another one");
    }

    public boolean unParkCar(Integer slotNumber, CarDao carDetails) {
        if (availabilityChecker.detailsOfCarInSlot.get(slotNumber) != null) {
           addAndRemoveCarDetails(slotNumber,null);
           return true;
        }
        return false;
    }

    private void addAndRemoveCarDetails(int slotNumber, CarDao carDetails) {
        availabilityChecker.detailsOfCarInSlot.remove(carDetails);
        availabilityChecker.detailsOfCarInSlot.add(slotNumber, carDetails);
    }
}
