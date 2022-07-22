package com.company.storage;

import com.company.cars.Car;
import com.company.cars.CargoCar;
import com.company.cars.ConvertibleCar;
import com.company.cars.PassengerCar;

public class Storage {

/*    Задание №3
    Мы с вами продвинулись в создании машин, но машины должны где то храниться!
    Для этого нам потребуется создать склад машин. Каждый склад может хранить в себе до 1000 машин разных типов.
    Поэтому необходимо:
            1. Создать новый класс склад. Который имеет количество машин при создании - 0.
            2. Создать в нем переменные, которые будут отвечать за хранение конкретного типа машин.
3. Создать методы добавления машин по каждому типу в переменные из шага два. При добавлении машины, свободное место на складе должно уменьшаться.
            4. Создать методы взятия машин со склада: общий счетчик уменьшается на 1, а в переменной ответственной за хранение машины определенной модели должна быть удалена конкретная машина. Методы возвращают экземпляр модели.
            5. Написать методы, которые будут показывать количество машин по каждой модели.
6. Расширить абстрактный класс Car, добавив атрибут Country (страна сборки). При сборке машины указать ее страну.
    Внимание! Запрещено использовать arrayList. Только массивы.*/

    private int availableCars;
    private int capacity;
    private CargoCar[] cargoCars;
    private PassengerCar[] passengerCars;
    private ConvertibleCar[] convertibleCars;

    public int getAvailableCars() {
        return availableCars;
    }

    public int getCapacity() {
        return capacity;
    }

    public Storage() {
        availableCars = 0;
        capacity = 1000;
        cargoCars = new CargoCar[capacity];
        passengerCars = new PassengerCar[capacity];
        convertibleCars = new ConvertibleCar[capacity];
    }

    private int getFirstFreeIndex(Car[] storage) {
        int currentStorageIndex = 0;
        while (currentStorageIndex < storage.length && storage[currentStorageIndex] != null) {
            currentStorageIndex++;
        }
        return currentStorageIndex;
    }

    private boolean addCar(Car car, Car[] storage) {
        if (availableCars == capacity) {
            System.out.println("Storage is full. Impossible to put car.");
            return false;
        }
        storage[getFirstFreeIndex(storage)] = car;
        availableCars++;
        return true;
    }

    public boolean addCargoCar(CargoCar cargoCar) {
        return addCar(cargoCar, cargoCars);
    }

    public boolean addPassengerCar(PassengerCar passengerCar) {
        return addCar(passengerCar, passengerCars);
    }

    public boolean addConvertibleCar(ConvertibleCar convertibleCar) {
        return addCar(convertibleCar, convertibleCars);
    }

    private Car getCar(Class CarClass) {
        if (CarClass == CargoCar.class) {
            int lastCargoIndex = getFirstFreeIndex(cargoCars) - 1;
            if (lastCargoIndex == -1) {
                System.out.println("No such cars on this storage");
                return null;
            }
            CargoCar cargoCar = cargoCars[lastCargoIndex];
            cargoCars[lastCargoIndex] = null;
            availableCars--;
            return cargoCar;
        } else if(CarClass == PassengerCar.class) {
            int lastPassengerIndex = getFirstFreeIndex(passengerCars) - 1;
            if (lastPassengerIndex == -1) {
                System.out.println("No such cars on this storage");
                return null;
            }
            PassengerCar passengerCar = passengerCars[lastPassengerIndex];
            passengerCars[lastPassengerIndex] = null;
            availableCars--;
            return passengerCar;
        } else if(CarClass == ConvertibleCar.class) {
            int lastConvertibleIndex = getFirstFreeIndex(convertibleCars) - 1;
            if (lastConvertibleIndex == -1) {
                System.out.println("No such cars on this storage");
                return null;
            }
            ConvertibleCar convertibleCar = convertibleCars[lastConvertibleIndex];
            convertibleCars[lastConvertibleIndex] = null;
            availableCars--;
            return convertibleCar;
        } else {
            System.out.println("such type of cars: " + CarClass + " isn't available on this storage");
            return null;
        }
    }

    public CargoCar getCargoCar() {
        return (CargoCar) getCar(CargoCar.class);
    }

    public PassengerCar getPassengerCar() {
        return (PassengerCar) getCar(PassengerCar.class);
    }

    public ConvertibleCar getConvertibleCar() {
        return (ConvertibleCar) getCar(ConvertibleCar.class);
    }

    public int getCargoCarAmount() {
        return getFirstFreeIndex(cargoCars);
    }

    public int getPassengerCarAmount() {
        return getFirstFreeIndex(passengerCars);
    }

    public int getConvertibleCarAmount() {
        return getFirstFreeIndex(convertibleCars);
    }
}
