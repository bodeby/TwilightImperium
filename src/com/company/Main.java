package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Twilight Imperium\n");

        Galaxy galaxy = GalaxyConfig.Create();

        //galaxy.getGalaxyInfo();

        //galaxy.getPlayerShips(galaxy.blue);
        //galaxy.getPlayerShips(galaxy.red);

        // Demo Controlled
        galaxy.getCenter().setControlledBy(galaxy.blue);
        galaxy.getNorth().setControlledBy(galaxy.red);

        //galaxy.getGalaxyStatus();

        Galaxy testGalaxy = GalaxyGenerator.generate();

        testGalaxy.getGalaxyInfo();

    }
}
