package com.parkingLot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotAvailabilityCheckerTest {

    ParkingLotAvailabilityChecker availabilityChecker = new ParkingLotAvailabilityChecker();
    @Test
    public void givenArrayAllocation_ShouldReturnCount5() {
        int emptySlotSize = availabilityChecker.detailsOfCarInSlot.size();
        Assert.assertEquals(5, emptySlotSize);
    }

    @Test
    public void givenSlotNumber_CheckIfEmpty() {
        int expectedEmptySlot = 1;
        try {
            int emptySlot = availabilityChecker.giveEmptySlot();
            Assert.assertEquals(expectedEmptySlot, emptySlot);
        } catch (ParkingSlotException e) {
            e.printStackTrace();
        }
    }
}
