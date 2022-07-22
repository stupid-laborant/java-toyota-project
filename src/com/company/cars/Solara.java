package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.Country;

public class Solara extends ConvertibleCar{
    public static final WheelSize WHEEL_SIZE = WheelSize.WHEEL_DIAMETER_16;
    public static final int NUMBER_OF_WHEELS = 4;

    public Solara(String color,
                  int maxSpeed,
                  TransmissionType transmissionType,
                  float price,
                  Country country,
                  Wheel... wheels) throws CarCreationException {
        super(NUMBER_OF_WHEELS, WHEEL_SIZE, color, maxSpeed, transmissionType, price, country, wheels);
    }

    public void coolDrink() {
        System.out.println("drink has been cooled");
    }
}
