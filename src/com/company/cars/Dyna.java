package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;

public class Dyna extends CargoCar{
    public static final WheelSize WHEEL_SIZE = WheelSize.WHEEL_DIAMETER_20;
    public static final int NUMBER_OF_WHEELS = 4;

    public Dyna(String color, int maxSpeed, TransmissionType transmissionType, float price, int capacity, Wheel... wheels) throws CarCreationException {
        super(NUMBER_OF_WHEELS, WHEEL_SIZE, color, maxSpeed, transmissionType, price, capacity, wheels);
    }

    public void chargePhone() {
        System.out.println("phone is charged");
    }
}
