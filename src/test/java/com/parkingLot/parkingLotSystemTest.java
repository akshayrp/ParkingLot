package com.parkingLot;

import org.junit.Assert;
import org.junit.Test;


import java.util.Date;

public class parkingLotSystemTest {

    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    @Test
    public void givenArrayAllocation_ShouldReturnCount5() {
        int emptySlotSize = parkingLotSystem.detailsOfCarInSlot.size();
        Assert.assertEquals(5, emptySlotSize);
    }

    @Test
    public void givenSlotNumber_CheckIfEmpty() {
        int expectedEmptySlot = 1;
        try {
            int emptySlot = parkingLotSystem.giveEmptySlot();
            Assert.assertEquals(expectedEmptySlot, emptySlot);
        } catch (ParkingSlotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCarDetail_ShouldParkCarOnAnEmptySlot() {
        try {
            Integer emptySlot = parkingLotSystem.giveEmptySlot();
            CarDao carDetails1 = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot);
            Assert.assertTrue(parkingLotSystem.parkCar(emptySlot, carDetails1));
        } catch (ParkingSlotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMultipleCarDetails_ShouldParkCarOnAnEmptySlot() {
        try {
            Integer emptySlot = parkingLotSystem.giveEmptySlot();
            CarDao carDetails = new CarDao("MH01 AJ 1234", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot);
            Assert.assertTrue(parkingLotSystem.parkCar(emptySlot, carDetails));
            Integer emptySlot1 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails1 = new CarDao("MH01 AJ 4567", "BMW", "White", new Date(), ParkingType.SMALL_VEHICLE, emptySlot1);
            Assert.assertTrue(parkingLotSystem.parkCar(emptySlot1, carDetails1));
            Integer emptySlot2 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails2 = new CarDao("MH01 AJ 7890", "KIA", "Black", new Date(), ParkingType.HANDICAP, emptySlot2);
            Assert.assertTrue(parkingLotSystem.parkCar(emptySlot2, carDetails2));
            Integer emptySlot3 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails3 = new CarDao("MH01 AJ 4566", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot3);
            Assert.assertTrue(parkingLotSystem.parkCar(emptySlot3, carDetails3));
        } catch (ParkingSlotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCarSlotNumber_WhenCarAvailable_UnParkCarShouldReturnTrue() {
        try {
            int emptySlotForFirstCar = parkingLotSystem.giveEmptySlot();
            CarDao firstCarDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
            parkingLotSystem.parkCar(emptySlotForFirstCar, firstCarDetails);
            Assert.assertTrue(parkingLotSystem.unParkCar(emptySlotForFirstCar));
        } catch (ParkingSlotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCarSlotNumber_WhenCarNotAvailable_UnParkCarShouldReturnFalse() {
        try {
            int emptySlotForFirstCar = parkingLotSystem.giveEmptySlot();
            CarDao firstCarDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
            Assert.assertFalse(parkingLotSystem.unParkCar(emptySlotForFirstCar));
        } catch (ParkingSlotException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMultipleCarDetails_WhenParkingLotFull_ShouldInformParkingFull() {
        try {
            Integer emptySlot = parkingLotSystem.giveEmptySlot();
            CarDao carDetails = new CarDao("MH01 AJ 1234", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot);
            parkingLotSystem.parkCar(emptySlot, carDetails);
            Integer emptySlot1 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails1 = new CarDao("MH01 AJ 4567", "BMW", "White", new Date(), ParkingType.SMALL_VEHICLE, emptySlot1);
            parkingLotSystem.parkCar(emptySlot1, carDetails1);
            Integer emptySlot2 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails2 = new CarDao("MH01 AJ 7890", "KIA", "Black", new Date(), ParkingType.HANDICAP, emptySlot2);
            parkingLotSystem.parkCar(emptySlot2, carDetails2);
            Integer emptySlot3 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails3 = new CarDao("MH01 AJ 4566", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot3);
            parkingLotSystem.parkCar(emptySlot3, carDetails3);
            Integer emptySlot4 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails4 = new CarDao("MH01 AJ 4566", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot4);
            parkingLotSystem.parkCar(emptySlot4, carDetails4);
            Integer emptySlot5 = parkingLotSystem.giveEmptySlot();
            CarDao carDetails5 = new CarDao("MH01 AJ 4566", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlot5);
            parkingLotSystem.parkCar(emptySlot5, carDetails5);
        } catch (ParkingSlotException e) {
            Assert.assertEquals(ParkingSlotException.ExceptionType.ALL_SLOTS_FULL, e.type);
        }
    }

    @Test
    public void givenCarSlotNumber_WhenCarAlreadyAvailable_ShouldNotAbleToParkCar() {
        try {
            int emptySlotForFirstCar = parkingLotSystem.giveEmptySlot();
            CarDao firstCarDetails = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
            parkingLotSystem.parkCar(emptySlotForFirstCar, firstCarDetails);
            CarDao firstCarDetails1 = new CarDao("MH01 AJ 1684", "BMW", "red", new Date(), ParkingType.LARGE_VEHICLE, emptySlotForFirstCar);
            parkingLotSystem.parkCar(emptySlotForFirstCar, firstCarDetails1);
        } catch (ParkingSlotException e) {
            Assert.assertEquals(ParkingSlotException.ExceptionType.SLOT_IS_OCCUPIED, e.type);
        }
    }
}

