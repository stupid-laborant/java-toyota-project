package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.Country;
import com.company.sales.CarPrices;

public abstract class ConvertibleCar extends Car{
    public ConvertibleCar(int number_of_wheels,
                          WheelSize wheelSize,
                          String color,
                          int maxSpeed,
                          TransmissionType transmissionType,
                          float price,
                          CarPrices cost,
                          Country country,
                          Wheel... wheels) throws CarCreationException {
        super(number_of_wheels, wheelSize, color, maxSpeed, transmissionType, price, cost, country, wheels);
        this.isRoofOpen = false;
    }

    protected boolean isRoofOpen;

    public void changeRoofStatus() {
        isRoofOpen = !isRoofOpen;
    }

    public boolean isRoofOpen() {
        return isRoofOpen;
    }
}
