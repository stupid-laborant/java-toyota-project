package com.company.cars;

import com.company.cars.components.*;
import com.company.cars.exceptions.CarCreationException;
import com.company.cars.exceptions.StartCarException;
import com.company.factory.Country;

import java.util.ArrayList;
import java.util.List;

public abstract class Car {

    protected Country country;
    protected WheelSize wheelSize;
    protected final int NUMBER_OF_WHEELS;
    protected String color;
    protected int maxSpeed;
    protected TransmissionType transmissionType;
    protected boolean isMoving;
    protected float price;
    protected List<Wheel> wheels;
    protected Tank tank;
    protected Engine engine;
    protected Electrics electrics;
    protected Headlight headlight;

    protected Car(int number_of_wheels,
                  WheelSize wheelSize,
                  String color,
                  int maxSpeed,
                  TransmissionType transmissionType,
                  float price,
                  Country country,
                  Wheel... wheels) throws CarCreationException {
        NUMBER_OF_WHEELS = number_of_wheels;
        this.wheelSize = wheelSize;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.price = price;
        this.isMoving = false;
        this.country = country;
        this.wheels = new ArrayList<>(NUMBER_OF_WHEELS);
        for (Wheel wheel: wheels) {
            if (wheels.length != NUMBER_OF_WHEELS) {
                throw new CarCreationException("Wrong amount of wheels: " + wheels.length);
            }
            if (wheel.getSize() != wheelSize) {
                throw new CarCreationException("Wheel " + wheel + " doesn't fit to this car");
            }
            this.wheels.add(wheel);

        }
        this.tank = new Tank();
        this.engine = new Engine();
        this.electrics = new Electrics();
        this.headlight = new Headlight();
    }

    public void startMoving() throws StartCarException {
        StringBuilder message = new StringBuilder();
        checkComponent(message, tank.getGasoline() > 0, "tank is empty");
        checkComponent(message, engine.isFunctional(), "engine malfunction");
        checkComponent(message, electrics.isFunctional(), "electric malfunction");
        checkComponent(message, headlight.isFunctional(), "headlight malfunction");
        int brokenTires = 0;
        for (Wheel wheel: wheels) {
            if (!wheel.isFunctional()) {
                brokenTires++;
            }
        }
        checkComponent(message, brokenTires == 0, brokenTires + " tires is broken");
        if (message.isEmpty()) {
            isMoving = true;
        } else {
            throw new StartCarException(message.toString());
        }

    }

    public void stopMoving() {
        isMoving = false;
    }

    public boolean turnHeadlight() {
        return headlight.isFunctional();
    }

    public int fillTank(int fuel) {
        tank.setGasoline(tank.getGasoline() + fuel);
        return tank.getGasoline();
    }

    private void checkComponent(StringBuilder message, boolean component, String errorMessage) {
        if (!component) {
            if (!message.isEmpty()) {
                message.append("; ");
            }
            message.append(errorMessage);
        }
    }

}
