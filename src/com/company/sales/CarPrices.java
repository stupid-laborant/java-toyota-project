package com.company.sales;

public enum CarPrices {
    CAMRY(5000),
    SOLARA(8000),
    HIANCE(10000),
    DYNA(12000);

    private int price;

    int getPrice() {
        return price;
    }

    CarPrices(int price) {
        this.price = price;
    }
}
