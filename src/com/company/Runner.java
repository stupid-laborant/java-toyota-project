package com.company;

import com.company.cars.Camry;
import com.company.cars.Dyna;
import com.company.cars.Hiance;
import com.company.cars.Solara;
import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.cars.exceptions.StartCarException;
import com.company.factory.AssemblyLine;
import com.company.factory.Country;
import com.company.factory.Factory;
import com.company.persons.Buyer;
import com.company.persons.Cashier;
import com.company.persons.Manager;
import com.company.storage.Storage;

public class Runner {
    public static void main(String[] args) throws Exception {
/*        AssemblyLine assemblyLine = new AssemblyLine(Country.JAPAN, new Factory(Country.JAPAN));

        Camry camry = assemblyLine.createCamry("black", 1000000f);
        Solara solara = assemblyLine.createSolara("red", 2000000f);
        Hiance hiance = assemblyLine.createHiance("white", 500000f);
        Dyna dyna = assemblyLine.createDyna("blue", 600000f);

        System.out.println("-----");
        System.out.println("Camry methods:");
        System.out.println("Camry fuel: " + camry.fillTank(10));
        camry.connectMusic();
        System.out.println("Camry moving: " + camry.isMoving());
        System.out.println("try to start moving camry...");
        camry.startMoving();
        System.out.println("Camry moving: " + camry.isMoving());
        System.out.println("Headlights: " + camry.turnHeadlight());
        System.out.println("Cruise status: " + camry.isCruiseControl());
        System.out.println("Try to turn on cruise control...");
        camry.changeCruiseControlStatus();
        System.out.println("Cruise status: " + camry.isCruiseControl());
        System.out.println("Try to stop camry....");
        camry.stopMoving();
        System.out.println("Camry moving: " + camry.isMoving());

        System.out.println("-----");
        System.out.println("Solara methods:");
        System.out.println("Solara fuel: " + solara.fillTank(12));
        System.out.println("Let's cool some drinks");
        solara.coolDrink();
        System.out.println("Solara is roof open: " + solara.isRoofOpen());
        System.out.println("Try to open roof....");
        solara.changeRoofStatus();
        System.out.println("Solara is roof open: " + solara.isRoofOpen());
        System.out.println("Try to close roof....");
        solara.changeRoofStatus();
        System.out.println("Solara is roof open: " + solara.isRoofOpen());
        System.out.println("Solara moving: " + solara.isMoving());
        System.out.println("try to start moving solara...");
        solara.startMoving();
        System.out.println("Solara moving: " + solara.isMoving());
        System.out.println("Headlights: " + solara.turnHeadlight());
        System.out.println("Try to stop solara....");
        solara.stopMoving();
        System.out.println("Solara moving: " + solara.isMoving());

        System.out.println("-----");
        System.out.println("Hiance methods:");
        System.out.println("Hiance fuel: " + hiance.fillTank(50));
        System.out.println("Hiance capacity: " + hiance.getCapacity());
        Wheel wrongSpareWheel = new Wheel(WheelSize.WHEEL_DIAMETER_14);
        System.out.println("Try to set spare wheel with " + wrongSpareWheel.getSize() + " size");
        hiance.setSpareWheel(wrongSpareWheel);
        Wheel spareWheel = new Wheel(Hiance.WHEEL_SIZE);
        System.out.println("Try to set spare wheel with " + spareWheel.getSize() + " size");
        hiance.setSpareWheel(spareWheel);
        System.out.println("Hiance spare wheel: " + hiance.getSpareWheel());
        System.out.println("Hiance moving: " + hiance.isMoving());
        System.out.println("try to start moving hiance...");
        hiance.startMoving();
        System.out.println("Hiance moving: " + hiance.isMoving());
        System.out.println("Headlights: " + hiance.turnHeadlight());
        System.out.println("Try to stop hiance....");
        hiance.stopMoving();
        System.out.println("Hiance moving: " + hiance.isMoving());

        System.out.println("-----");
        System.out.println("Dyna methods:");
        System.out.println("Dyna fuel: " + dyna.fillTank(50));
        System.out.println("Dyna capacity: " + dyna.getCapacity());
        System.out.println("Let's charge the phone...");
        dyna.chargePhone();
        System.out.println("Dyna moving: " + dyna.isMoving());
        System.out.println("try to start moving dyna...");
        dyna.startMoving();
        System.out.println("Dyna moving: " + dyna.isMoving());
        System.out.println("Headlights: " + dyna.turnHeadlight());
        System.out.println("Try to stop dyna....");
        dyna.stopMoving();
        System.out.println("Dyna moving: " + dyna.isMoving());

        System.out.println("-----");
        System.out.println("Storage:");
        Storage storage = new Storage();
        storage.addCargoCar(hiance);
        storage.addCargoCar(dyna);
        storage.addConvertibleCar(solara);
        storage.addPassengerCar(camry);
        System.out.println(storage.getAvailableCars());
        System.out.println(storage.getCargoCar());
        System.out.println(storage.getAvailableCars());
        System.out.println(storage.getConvertibleCar());
        System.out.println(storage.getAvailableCars());
        System.out.println(storage.getPassengerCar());
        System.out.println(storage.getAvailableCars());
        System.out.println(storage.getCargoCarAmount());
        System.out.println(storage.getPassengerCar());*/

        Factory factory = new Factory(Country.JAPAN);
        AssemblyLine assemblyLine1 = new AssemblyLine(Country.JAPAN, factory);
        Storage storage1 = new Storage();
        storage1.addCargoCar(assemblyLine1.createDyna("black", 22000f));
        storage1.addPassengerCar(assemblyLine1.createCamry("black", 10000f));
        storage1.addConvertibleCar(assemblyLine1.createSolara("white", 12000f));
        storage1.addCargoCar(assemblyLine1.createHiance("black", 15000f));

        Manager manager = new Manager("baryga", assemblyLine1, storage1);
        Cashier cashier = new Cashier();
        manager.setCashier(cashier);
        Buyer buyer1 = new Buyer("john", 10000d);
        System.out.println(manager.sellCar(buyer1));
        Buyer buyer2 = new Buyer("frank", 12000d);
        System.out.println(manager.sellCar(buyer2));
        Buyer buyer3= new Buyer("simon", 15000d);
        System.out.println(manager.sellCar(buyer3));
        Buyer buyer4= new Buyer("simon", 22000d);
        System.out.println(manager.sellCar(buyer4));

        Buyer buyer5 = new Buyer("john", 11000d);
        System.out.println(manager.sellCar(buyer5));
        Buyer buyer6 = new Buyer("frank", 13000d);
        System.out.println(manager.sellCar(buyer6));
        Buyer buyer7= new Buyer("simon", 8000d);
        System.out.println(manager.sellCar(buyer7));
        Buyer buyer8= new Buyer("simon", 30000d);
        System.out.println(manager.sellCar(buyer8));

        System.out.println(cashier.getTotalIncome());



    }
}
