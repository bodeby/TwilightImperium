package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Twilight Imperium");

        Galaxy galaxy = GalaxyConfig.Create();

        galaxy.getGalaxyInfo();

        System.out.println(galaxy.getNorth().getPlanets());

        System.out.println(galaxy.getPlayerShips(galaxy.red));

        //galaxy.getPlayerShips(galaxy.red);
        //galaxy.getPlayerShips(galaxy.blue);

    }
}
