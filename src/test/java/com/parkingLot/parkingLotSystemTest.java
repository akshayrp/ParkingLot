package com.parkingLot;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class parkingLotSystemTest {

    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    @Test
    public void givenArrayAllocation_ShouldReturnCount100() {
        int emptySlotSize = parkingLotSystem.slot.length * parkingLotSystem.slot.length;
        Assert.assertEquals(100, emptySlotSize);
    }

    @Test
    public void givenSlotNumber_CheckIfEmpty() {
        int firstSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] expectedEmptySlot = {1,8};
        Integer[] emptySlot = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingType, lastSlotNumberOfParkingType);
        Assert.assertArrayEquals(expectedEmptySlot,emptySlot);
    }

    @Test
    public void givenCarDetail_ShouldStoreCarDetails() {
        int firstSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] emptySlot = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingType,lastSlotNumberOfParkingType);
        CarDao carDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot);
        parkingLotSystem.parkCar(emptySlot, carDetails);
    }
}
