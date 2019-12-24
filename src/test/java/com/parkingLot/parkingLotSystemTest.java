package com.parkingLot;

import org.junit.Assert;
import org.junit.Test;

public class parkingLotSystemTest {

    @Test
    public void givenArrayAllocation_ShouldReturnCount100() {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        int emptySlotSize = parkingLotSystem.slot.length * parkingLotSystem.slot.length;
        Assert.assertEquals(100, emptySlotSize);
    }
}
