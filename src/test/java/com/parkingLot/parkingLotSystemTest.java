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
    public void givenSlotNumber_CheckIfEmpty() throws ParkingSlotException {
        int firstSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] expectedEmptySlot = {1,8};
        Integer[] emptySlot = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingType, lastSlotNumberOfParkingType);
        Assert.assertArrayEquals(expectedEmptySlot,emptySlot);
    }

    @Test
    public void givenCarDetail_ShouldParkCarOnAnEmptySlot() throws ParkingSlotException {
        int firstSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingType = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] emptySlot = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingType,lastSlotNumberOfParkingType);
        CarDao carDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot);
        parkingLotSystem.parkCar(emptySlot, carDetails);
    }

    @Test
    public void givenMultipleCarDetails_ShouldParkCarOnAnEmptySlotBasedOnParkingType() throws ParkingSlotException {
        int firstSlotNumberOfParkingTypeFirstCar = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingTypeFirstCar = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] emptySlotForFirstCar = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingTypeFirstCar,lastSlotNumberOfParkingTypeFirstCar);
        CarDao FirstCarDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
        parkingLotSystem.parkCar(emptySlotForFirstCar, FirstCarDetails);
        int firstSlotNumberOfParkingTypeSecondCar = ParkingType.SMALL_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingTypeSecondCar = ParkingType.SMALL_VEHICLE.endingSlot;
        Integer[] emptySlotForSecondCar = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingTypeSecondCar,lastSlotNumberOfParkingTypeSecondCar);
        CarDao SecondCarDetails = new CarDao("MH01 AJ 1113", "duster", "white", new Date(), ParkingType.SMALL_VEHICLE, emptySlotForSecondCar);
        parkingLotSystem.parkCar(emptySlotForSecondCar, SecondCarDetails);
        int firstSlotNumberOfParkingTypeThirdCar = ParkingType.HANDICAP.startingSlot;
        int lastSlotNumberOfParkingTypeThirdCar = ParkingType.HANDICAP.endingSlot;
        Integer[] emptySlotForThirdCar = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingTypeThirdCar,lastSlotNumberOfParkingTypeThirdCar);
        CarDao thirdCarDetails = new CarDao("MH01 AJ 1113", "duster", "white", new Date(), ParkingType.SMALL_VEHICLE, emptySlotForThirdCar);
        parkingLotSystem.parkCar(emptySlotForThirdCar, thirdCarDetails);
    }

    @Test
    public void givenCarSlotNumber_WhenCarAvailable_UnParkCarShouldReturnTrue() throws ParkingSlotException {
        int firstSlotNumberOfParkingTypeFirstCar = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingTypeFirstCar = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] emptySlotForFirstCar = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingTypeFirstCar,lastSlotNumberOfParkingTypeFirstCar);
        CarDao FirstCarDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
        parkingLotSystem.parkCar(emptySlotForFirstCar, FirstCarDetails);
        Assert.assertTrue(parkingLotSystem.unParkCar(emptySlotForFirstCar));
    }

    @Test
    public void givenCarSlotNumber_WhenCarNotAvailable_UnParkCarShouldReturnFalse() throws ParkingSlotException {
        int firstSlotNumberOfParkingTypeFirstCar = ParkingType.LARGE_VEHICLE.startingSlot;
        int lastSlotNumberOfParkingTypeFirstCar = ParkingType.LARGE_VEHICLE.endingSlot;
        Integer[] emptySlotForFirstCar = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingTypeFirstCar,lastSlotNumberOfParkingTypeFirstCar);
        CarDao FirstCarDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
        Assert.assertFalse(parkingLotSystem.unParkCar(emptySlotForFirstCar));
    }

}
