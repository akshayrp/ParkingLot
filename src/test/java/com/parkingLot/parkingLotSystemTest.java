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
        int firstSlotNumberOfParkingType = ParkingType.NORMAL.startingSlot;
        Integer[] expectedEmptySlot = {1, 8};
        Integer[] emptySlot = parkingLotSystem.giveEmptySlot(firstSlotNumberOfParkingType);
        Assert.assertArrayEquals(expectedEmptySlot, emptySlot);
    }
}
