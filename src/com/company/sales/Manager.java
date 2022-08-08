package com.company.sales;

import com.company.cars.Car;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.AssemblyLine;
import com.company.storage.Storage;

import java.io.FileWriter;
import java.io.IOException;

public class Manager {
    private String name;
    private AssemblyLine assemblyLine;
    private Storage storage;
    private Report report;
    private Cashier cashier;

    public Manager(String name, AssemblyLine assemblyLine, Storage storage) {
        this.name = name;
        this.assemblyLine = assemblyLine;
        this.storage = storage;
        this.report = new Report(this);
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public String getName() {
        return name;
    }

    public Car sellCar(Buyer buyer) throws CarCreationException {
        if (storage.getAvailableCars() == 0) {
            storage.addPassengerCar(assemblyLine.createCamry("black", 10000f));
            storage.addConvertibleCar(assemblyLine.createSolara("white", 12000f));
            storage.addCargoCar(assemblyLine.createDyna("black", 22000f));
            storage.addCargoCar(assemblyLine.createHiance("black", 15000f));
        }
        Car car = storage.getProperCar(buyer.getMoney());
        if (car != null) {
            buyer.takeMoney(car.getPrice());
            cashier.registerTransaction(car);
            report.registerDeal(car);
        }
        return car;
    }

    public void generateReport() throws IOException {
        Car[] soldCars = report.getSoldCars();
        try (FileWriter writer = new FileWriter("manager " + this.name + " report.txt", false)) {
            writer.write(this.name + System.lineSeparator());
            for (int i = 0; i < soldCars.length; i++) {
                Car currentCar = soldCars[i];
                writer.write(currentCar.getClass().getSimpleName() + " - " + currentCar.getPrice() + " - "+ currentCar.cost.getPrice() + System.lineSeparator());
            }
            writer.flush();
        }
    }

    public int getTotalIncome() {
        Car[] soldCars = report.getSoldCars();
        int totalIncome = 0;
        for (int i = 0; i < soldCars.length; i++) {
            totalIncome += soldCars[i].getPrice();
        }
        return totalIncome;
    }

    public int getTotalCost() {
        Car[] soldCars = report.getSoldCars();
        int totalCost = 0;
        for (int i = 0; i < soldCars.length; i++) {
            totalCost += soldCars[i].cost.getPrice();
        }
        return totalCost;
    }

    public int getTotalProfit() {
        return getTotalIncome() - getTotalCost();
    }
}
