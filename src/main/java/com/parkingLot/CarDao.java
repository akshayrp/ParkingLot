package com.parkingLot;

import java.util.Date;

public class CarDao
{
    String numberPlate;
    String Model;
    String color;
    Date time;
    String parkingType;
    Integer slotNumber;

    public CarDao() {
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getModel() {
        return Model;
    }

    public String getColor() {
        return color;
    }

    public Date getTime() {
        return time;
    }

    public String getParkingType() {
        return parkingType;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }
}
