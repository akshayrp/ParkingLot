package com.parkingLot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class parkingLotSystemTest {

    @Mock
    CarParkingManager manager;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    ParkingLotSystem parkingLotSystem;
    CarDao firstCar;
    CarDao secondCar;

    @Before
    public void setUp(){
        this.parkingLotSystem  = new ParkingLotSystem();
        this.manager = mock(CarParkingManager.class);
        this.firstCar = new CarDao("MH01 AJ 0123", "Toyota", "red", new Date(), ParkingType.LARGE_VEHICLE, 1);
        this.secondCar = new CarDao("MH01 AJ 0178", "BMW", "red", new Date(), ParkingType.SMALL_VEHICLE, 2);
    }

    @Test
    public void givenCarDetailsAndSlotNumber_ShouldParkCarOnThatSlot() {
        this.parkingLotSystem.setParkingManager(manager);
        when(manager.parkCar(1,firstCar)).thenReturn(true);
        Assert.assertTrue(parkingLotSystem.parkCar(1,firstCar));
    }

    @Test
    public void givenCarSlotNumber_ShouldUnParkCarOnThatSlot() {
        this.parkingLotSystem.setParkingManager(manager);
        when(manager.unParkCar(1,firstCar)).thenReturn(true);
        Assert.assertTrue(parkingLotSystem.unParkCar(1,firstCar));
    }
}

