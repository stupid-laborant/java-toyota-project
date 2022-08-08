package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.Country;
import com.company.sales.CarPrices;

public class Dyna extends CargoCar{
    public static final CarPrices COST = CarPrices.DYNA;
    public static final WheelSize WHEEL_SIZE = WheelSize.WHEEL_DIAMETER_20;
    public static final int NUMBER_OF_WHEELS = 4;

    public Dyna(String color,
                int maxSpeed,
                TransmissionType transmissionType,
                float price,
                Country country,
                int capacity,
                Wheel... wheels) throws CarCreationException {
        super(NUMBER_OF_WHEELS, WHEEL_SIZE, color, maxSpeed, transmissionType, price, CarPrices.DYNA, country, capacity, wheels);
    }

    public void chargePhone() {
        System.out.println("phone is charged");
    }
}
