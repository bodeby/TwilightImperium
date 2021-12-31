package com.company;

import com.company.Units.Destroyer;
import com.company.Units.Dreadnought;

public class Main {

    public static void main(String[] args) {
        System.out.println("Twilight Imperium\n");

        Galaxy galaxy = GalaxyConfig.Create();

        // Demo Controlled
        galaxy.getCenter().setControlledBy(galaxy.blue);
        galaxy.getNorth().setControlledBy(galaxy.red);

        Galaxy testGalaxy = GalaxyGenerator.generate();

        testGalaxy.getGalaxyInfo();

        System.out.println(testGalaxy.getRed());
        System.out.println(testGalaxy.getBlue());


        galaxy.getNorth().addShip(new Dreadnought(galaxy.blue));
        galaxy.getNorth().addShip(new Destroyer(galaxy.blue));

        galaxy.getNorth().spaceBattle();

    }
}
