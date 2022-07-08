package com.company.cars.components;

public class Wheel {
    private int size;
    private boolean isSlashed;

    public Wheel(int size) {
        this.size = size;
        this.isSlashed = false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSlashed() {
        return isSlashed;
    }

    public void setSlashed(boolean slashed) {
        isSlashed = slashed;
    }
}
