package com.parkingLot;

import org.junit.Assert;
import org.junit.Test;

public class parkingLotSystemTest {

    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();

    @Test
    public void givenArrayAllocation_ShouldReturnCount100() {
        int emptySlotSize = parkingLotSystem.slot.length * parkingLotSystem.slot.length;
        Assert.assertEquals(100, emptySlotSize);
    }

    @Test
    public void givenSlotNumber_CheckIfEmpty() {
        Integer[] expectedEmptySlot = {1,1};
        Integer[] emptySlot = parkingLotSystem.giveEmptySlot();
        Assert.assertArrayEquals(expectedEmptySlot,emptySlot);
    }
}
