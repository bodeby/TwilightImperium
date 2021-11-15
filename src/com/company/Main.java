package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Twilight");


        Player blue = new Player("Crassus", "The Emirates of Hacan", "blue");
        Player red = new Player("Pompey", "Federation of Sol", "red");

        Set<Planet> centerPlanets = new HashSet<>();
        Planet planet1 = new Planet(PlanetNames.MecatolRex);
        Planet planet2 = new Planet(PlanetNames.VegaMinor);
        Planet planet3 = new Planet(PlanetNames.VegaMajor);

        centerPlanets.add(planet1);
        centerPlanets.add(planet2);

        ArrayList<Unit> blueUnits = new ArrayList<>();
        Carrier carrier1 = new Carrier(blue);
        Carrier carrier2 = new Carrier(blue);

        blueUnits.add(carrier1);
        blueUnits.add(carrier2);

        Dreadnought dn = new Dreadnought(red);

        SolarSystem center = new SolarSystem(centerPlanets,blueUnits);
        center.addShip(dn);

        for (Unit ship : center.getShips()) {
            System.out.println(ship.toString());
        }

        for (Planet planet : center.getPlanets()) {
            System.out.println(planet.toString());
        }
    }
}
