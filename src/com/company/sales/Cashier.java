package com.company.sales;

import com.company.cars.Car;

import java.util.Arrays;

public class Cashier {
    private static double[] income = new double[1000];
    private static int pointer = 0;

    private String name;

    public String getName() {
        return name;
    }

    public double getTotalIncome() {
        double sum = 0d;
        for (int i = 0; i <= pointer; i++) {
            sum += income[i];
        }
        return sum;
    }

    public void registerTransaction(Car car) {
        int currentLength = income.length;
        if (pointer == currentLength - 1) {
            income = Arrays.copyOf(income, (int)(1.5 * currentLength));
        }
        income[pointer++] = car.getPrice();
    }
}
