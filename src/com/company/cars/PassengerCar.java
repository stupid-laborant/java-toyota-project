package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.Country;
import com.company.sales.CarPrices;

public abstract class PassengerCar extends Car{
    public PassengerCar(int number_of_wheels,
                        WheelSize wheelSize,
                        String color,
                        int maxSpeed,
                        TransmissionType transmissionType,
                        float price,
                        CarPrices cost,
                        Country country,
                        Wheel... wheels) throws CarCreationException {
        super(number_of_wheels, wheelSize, color, maxSpeed, transmissionType, price, cost, country, wheels);
        this.cruiseControl = false;
    }

    protected boolean cruiseControl;

    public void changeCruiseControlStatus() {
        cruiseControl = !cruiseControl;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }
}
