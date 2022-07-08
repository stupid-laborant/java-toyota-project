package com.company.cars.components;

public abstract class FunctionalComponent {
    protected boolean isFunctional;

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean functional) {
        isFunctional = functional;
    }

    protected FunctionalComponent() {
        this.isFunctional = true;
    }
}
