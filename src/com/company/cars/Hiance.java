package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;

public class Hiance extends CargoCar{
    public static final WheelSize WHEEL_SIZE = WheelSize.WHEEL_DIAMETER_20;
    public static final int NUMBER_OF_WHEELS = 4;

    public Hiance(String color, int maxSpeed, TransmissionType transmissionType, float price, int capacity, Wheel... wheels) throws CarCreationException {
        super(NUMBER_OF_WHEELS, WHEEL_SIZE, color, maxSpeed, transmissionType, price, capacity, wheels);
    }

    private Wheel spareWheel;

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(Wheel spareWheel) {
        if (spareWheel.getSize() == WHEEL_SIZE) {
            this.spareWheel = spareWheel;
        } else {
            System.out.println("Spare wheel couldn't be set fue to wrong size: " + spareWheel.getSize() + " instead of: " + WHEEL_SIZE);
        }
    }
}
