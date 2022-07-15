package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;

public abstract class CargoCar extends Car{
    public CargoCar(int number_of_wheels, WheelSize wheelSize, String color, int maxSpeed, TransmissionType transmissionType, float price, int capacity, Wheel... wheels) throws CarCreationException {
        super(number_of_wheels, wheelSize, color, maxSpeed, transmissionType, price, wheels);
        this.capacity = capacity;
    }

    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
