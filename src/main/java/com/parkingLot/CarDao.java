package com.parkingLot;

import java.util.Date;

public class CarDao
{
    String numberPlate;
    String Model;
    String color;
    Date time;
    ParkingType parkingType;
    Integer slotNumber;

    public CarDao(String numberPlate, String model, String color, Date time, ParkingType parkingType, Integer slotNumber) {
        this.numberPlate = numberPlate;
        Model = model;
        this.color = color;
        this.time = time;
        this.parkingType = parkingType;
        this.slotNumber = slotNumber;
    }
}
