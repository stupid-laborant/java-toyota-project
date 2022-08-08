package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.Country;
import com.company.sales.CarPrices;

public class Camry extends PassengerCar{
    public static final WheelSize WHEEL_SIZE = WheelSize.WHEEL_DIAMETER_17;
    public static final int NUMBER_OF_WHEELS = 4;

    public Camry(String color,
                 int maxSpeed,
                 TransmissionType transmissionType,
                 float price,
                 Country country,
                 Wheel... wheels) throws CarCreationException {
        super(NUMBER_OF_WHEELS, WHEEL_SIZE, color, maxSpeed, transmissionType, price, CarPrices.CAMRY, country, wheels);
    }

    public void connectMusic() {
        System.out.println("music connected");
    }
}
