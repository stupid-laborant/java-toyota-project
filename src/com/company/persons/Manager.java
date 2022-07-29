package com.company.persons;

import com.company.cars.Car;
import com.company.cars.exceptions.CarCreationException;
import com.company.factory.AssemblyLine;
import com.company.storage.Storage;

public class Manager {
    private String name;
    private AssemblyLine assemblyLine;
    private Storage storage;
    Cashier cashier;

    public Manager(String name, AssemblyLine assemblyLine, Storage storage) {
        this.name = name;
        this.assemblyLine = assemblyLine;
        this.storage = storage;
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
        }
        return car;
    }
}
