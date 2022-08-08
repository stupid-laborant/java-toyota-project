package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.Country;
import com.company.sales.CarPrices;

public abstract class CargoCar extends Car{
    public CargoCar(int number_of_wheels,
                    WheelSize wheelSize,
                    String color,
                    int maxSpeed,
                    TransmissionType transmissionType,
                    float price,
                    CarPrices cost,
                    Country country,
                    int capacity,
                    Wheel... wheels) throws CarCreationException {
        super(number_of_wheels, wheelSize, color, maxSpeed, transmissionType, price, cost, country, wheels);
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
