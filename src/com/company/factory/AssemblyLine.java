package com.company.factory;

import com.company.cars.Camry;
import com.company.cars.Dyna;
import com.company.cars.Hiance;
import com.company.cars.Solara;
import com.company.cars.components.*;
import com.company.cars.exceptions.CarCreationException;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class AssemblyLine {
    private final Country country;
    private final Factory factory;

    public AssemblyLine(Country country, Factory factory) throws Exception {
        this.country = country;
        Country factoryCountry = factory.getCountry();
        if (factoryCountry != country) {
            throw new CountyFactoryNotEqualException(factoryCountry, country);
        }
        this.factory = factory;
    }

    public Country getCountry() {
        return country;
    }

    public Factory getFactory() {
        return factory;
    }

    public Camry createCamry(String color, Float price) throws CarCreationException {
        Electrics electrics = factory.createElectrics();
        Engine engine = factory.createEngine();
        Headlight headlight = factory.createHeadlight();
        Tank tank = factory.createTank();
        Wheel[] wheels = new Wheel[Camry.NUMBER_OF_WHEELS];
        for (int i = 0; i < Camry.NUMBER_OF_WHEELS; i++) {
            wheels[i] = factory.createWheel(Camry.WHEEL_SIZE);
        }
        return new Camry(color, 200, TransmissionType.AUTOMATIC, price, country, wheels);
    }

    public Solara createSolara(String color, Float price) throws CarCreationException {
        Electrics electrics = factory.createElectrics();
        Engine engine = factory.createEngine();
        Headlight headlight = factory.createHeadlight();
        Tank tank = factory.createTank();
        Wheel[] wheels = new Wheel[Solara.NUMBER_OF_WHEELS];
        for (int i = 0; i < Solara.NUMBER_OF_WHEELS; i++) {
            wheels[i] = factory.createWheel(Solara.WHEEL_SIZE);
        }
        return new Solara(color, 200, TransmissionType.MECHANICS, price, country, wheels);
    }

    public Dyna createDyna(String color, Float price) throws CarCreationException {
        Electrics electrics = factory.createElectrics();
        Engine engine = factory.createEngine();
        Headlight headlight = factory.createHeadlight();
        Tank tank = factory.createTank();
        Wheel[] wheels = new Wheel[Dyna.NUMBER_OF_WHEELS];
        for (int i = 0; i < Dyna.NUMBER_OF_WHEELS; i++) {
            wheels[i] = factory.createWheel(Dyna.WHEEL_SIZE);
        }
        return new Dyna(color, 140, TransmissionType.MECHANICS, price, country, 1500, wheels);
    }


    public Hiance createHiance(String color, Float price) throws CarCreationException {
        Electrics electrics = factory.createElectrics();
        Engine engine = factory.createEngine();
        Headlight headlight = factory.createHeadlight();
        Tank tank = factory.createTank();
        Wheel[] wheels = new Wheel[Hiance.NUMBER_OF_WHEELS];
        for (int i = 0; i < Hiance.NUMBER_OF_WHEELS; i++) {
            wheels[i] = factory.createWheel(Hiance.WHEEL_SIZE);
        }
        return new Hiance(color, 160, TransmissionType.MECHANICS, price, country, 1000, wheels);
    }
}
