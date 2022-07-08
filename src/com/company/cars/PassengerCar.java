package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.exceptions.CarCreationException;

public abstract class PassengerCar extends Car{
    public PassengerCar(int number_of_wheels, int wheelSize, String color, int maxSpeed, TransmissionType transmissionType, float price, Wheel... wheels) throws CarCreationException {
        super(number_of_wheels, wheelSize, color, maxSpeed, transmissionType, price, wheels);
        this.cruiseControl = false;
    }

    protected boolean cruiseControl;

    public void turnOnCruise() {
        this.cruiseControl = true;
    }

    public void turnOfCruise() {
        this.cruiseControl = false;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }
}
