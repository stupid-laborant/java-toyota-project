package com.company.cars;

import com.company.cars.components.TransmissionType;
import com.company.cars.components.Wheel;
import com.company.cars.components.WheelSize;
import com.company.cars.exceptions.CarCreationException;
import com.company.cars.exceptions.StartCarException;

public class Runner {
    public static void main(String[] args) throws CarCreationException, StartCarException {
        Wheel[] camryWheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            camryWheels[i] = new Wheel(WheelSize.WHEEL_DIAMETER_17);
        }
        Camry camry = new Camry("black", 200, TransmissionType.AUTOMATIC, 1000000, camryWheels);

        Wheel[] solaraWheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            solaraWheels[i] = new Wheel(WheelSize.WHEEL_DIAMETER_16);
        }
        Solara solara = new Solara("red", 220, TransmissionType.ROBOT, 2000000, solaraWheels);

        Wheel[] hianceWheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            hianceWheels[i] = new Wheel(WheelSize.WHEEL_DIAMETER_20);
        }
        Hiance hiance = new Hiance("white", 160, TransmissionType.MECHANICS, 500000, 1000, hianceWheels);


        Wheel[] dynaWheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            dynaWheels[i] = new Wheel(WheelSize.WHEEL_DIAMETER_20);
        }
        Dyna dyna = new Dyna("blue", 140, TransmissionType.MECHANICS, 600000, 1500, dynaWheels);

        System.out.println("-----");
        System.out.println("Camry methods:");
        System.out.println("Camry fuel: " + camry.fillTank(10));
        camry.connectMusic();
        System.out.println("Camry moving: " + camry.isMoving);
        System.out.println("try to start moving camry...");
        camry.startMoving();
        System.out.println("Camry moving: " + camry.isMoving);
        System.out.println("Headlights: " + camry.turnHeadlight());
        System.out.println("Cruise status: " + camry.isCruiseControl());
        System.out.println("Try to turn on cruise control...");
        camry.changeCruiseControlStatus();
        System.out.println("Cruise status: " + camry.isCruiseControl());
        System.out.println("Try to stop camry....");
        camry.stopMoving();
        System.out.println("Camry moving: " + camry.isMoving);

        System.out.println("-----");
        System.out.println("Solara methods:");
        System.out.println("Solara fuel: " + solara.fillTank(12));
        System.out.println("Let's cool some drinks");
        solara.coolDrink();
        System.out.println("Solara is roof open: " + solara.isRoofOpen);
        System.out.println("Try to open roof....");
        solara.changeRoofStatus();
        System.out.println("Solara is roof open: " + solara.isRoofOpen);
        System.out.println("Try to close roof....");
        solara.changeRoofStatus();
        System.out.println("Solara is roof open: " + solara.isRoofOpen);
        System.out.println("Solara moving: " + solara.isMoving);
        System.out.println("try to start moving solara...");
        solara.startMoving();
        System.out.println("Solara moving: " + solara.isMoving);
        System.out.println("Headlights: " + solara.turnHeadlight());
        System.out.println("Try to stop solara....");
        solara.stopMoving();
        System.out.println("Solara moving: " + solara.isMoving);

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
        System.out.println("Hiance moving: " + hiance.isMoving);
        System.out.println("try to start moving hiance...");
        hiance.startMoving();
        System.out.println("Hiance moving: " + hiance.isMoving);
        System.out.println("Headlights: " + hiance.turnHeadlight());
        System.out.println("Try to stop hiance....");
        hiance.stopMoving();
        System.out.println("Hiance moving: " + hiance.isMoving);

        System.out.println("-----");
        System.out.println("Dyna methods:");
        System.out.println("Dyna fuel: " + dyna.fillTank(50));
        System.out.println("Dyna capacity: " + dyna.getCapacity());
        System.out.println("Let's charge the phone...");
        dyna.chargePhone();
        System.out.println("Dyna moving: " + dyna.isMoving);
        System.out.println("try to start moving dyna...");
        dyna.startMoving();
        System.out.println("Dyna moving: " + dyna.isMoving);
        System.out.println("Headlights: " + dyna.turnHeadlight());
        System.out.println("Try to stop dyna....");
        dyna.stopMoving();
        System.out.println("Dyna moving: " + dyna.isMoving);
    }
}
