package com.company.sales;

import com.company.cars.Car;

import java.util.Arrays;

public class Report {
    private Manager manager;
    private Car[] soldCars;
    private int pointer;

    public Report(Manager manager) {
        this.manager = manager;
        this.pointer = 0;
        this.soldCars = new Car[10];
    }

    public Manager getManager() {
        return manager;
    }

    public Car[] getSoldCars() {
        return Arrays.copyOf(soldCars, pointer);
    }

    public void registerDeal(Car car) {
        int soldCarsLength = soldCars.length;
        if (pointer == soldCarsLength) {
            soldCars = Arrays.copyOf(soldCars, (int)(1.5*soldCarsLength));
        }
        soldCars[pointer++] = car;

    }
}
