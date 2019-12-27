package com.parkingLot;

public class ParkingLotSystem {
    CarParkingManager parkingManager;

    public void setParkingManager(CarParkingManager parkingManager) {
        this.parkingManager = parkingManager;
    }

    public boolean parkCar(int slotNumber, CarDao carDetails){
        return parkingManager.parkCar(slotNumber, carDetails);
    }

    public boolean unParkCar(Integer slotNumber, CarDao carDetails) {
        return parkingManager.unParkCar(slotNumber, carDetails);
    }
}
