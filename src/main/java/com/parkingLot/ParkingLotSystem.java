package com.parkingLot;

public class ParkingLotSystem {
    ParkingLotAvailabilityChecker availabilityChecker;

    public ParkingLotSystem() {
        this.availabilityChecker = new ParkingLotAvailabilityChecker();
    }

    public boolean parkCar(int slotNumber, CarDao carDetails) throws ParkingSlotException {
        return availabilityChecker.parkCar(slotNumber, carDetails);
    }

    public boolean unParkCar(Integer slotNumber, CarDao carDetails) {
        return availabilityChecker.unParkCar(slotNumber, carDetails);
    }
}
