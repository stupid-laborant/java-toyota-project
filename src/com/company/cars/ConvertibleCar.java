package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.exceptions.CarCreationException;

public abstract class ConvertibleCar extends Car{
    public ConvertibleCar(int number_of_wheels, int wheelSize, String color, int maxSpeed, TransmissionType transmissionType, float price, Wheel... wheels) throws CarCreationException {
        super(number_of_wheels, wheelSize, color, maxSpeed, transmissionType, price, wheels);
        this.isRoofOpen = false;
    }

    protected boolean isRoofOpen;

    public void openRoof() {
        this.isRoofOpen = true;
    }

    public void closeRoof() {
        this.isRoofOpen = false;
    }

    public boolean isRoofOpen() {
        return isRoofOpen;
    }
}
