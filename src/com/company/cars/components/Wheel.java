package com.company.cars.components;

public class Wheel extends FunctionalComponent{
    private WheelSize wheelSize;

    public Wheel(WheelSize wheelSize) {
        super();
        this.wheelSize = wheelSize;
    }

    public WheelSize getSize() {
        return wheelSize;
    }
}
