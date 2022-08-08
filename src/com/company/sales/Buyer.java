package com.company.sales;

import com.company.cars.Car;

public class Buyer {
    private String name;
    private Double money;
    private Car car;

    public Buyer(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void takeMoney(double money) {
        this.money -= money;
    }
}
