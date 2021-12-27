package com.company;

import com.company.Units.Carrier;
import com.company.Units.Cruiser;
import com.company.Units.Destroyer;
import com.company.Units.Dreadnought;

/**
 * At the center is a system that contains the planet Mecatol Rex.
 * To the north is system that contains the planets Vega Minor and Vega Major.
 * To the north-east is an empty system.
 * To the south-east is a system that contains the planet Industrex.
 * To the south is a system that contains the planets Rigel I and Rigel II.
 * To the south-west is an empty system.
 * To the nort-west is a system that contains the planet Mirage.
 *
 * The Galaxy contains the following ships:
 * In the Mecatol Rex system there are two Dreadnoughts and a Destroyer owned by the blue player.
 * In the Vega Minor and Vega Major system there are two Cruisers and a Carrier owned by the red player.
 *
 * You decide on the unspecified properties of the Galaxy, e.g. planet resources.
 *
 */

public class GalaxyConfig {
    public static Galaxy Create() {
        // Test Players
        Player blue = new Player("Crassus", "The Emirates of Hacan", "blue");
        Player red = new Player("Pompey", "Federation of Sol", "red");

        // Galaxy
        Galaxy galaxy = new Galaxy();

        // Systems
        SolarSystem center      = new SolarSystem();
        SolarSystem north       = new SolarSystem();
        SolarSystem northEast   = new SolarSystem();
        SolarSystem southEast   = new SolarSystem();
        SolarSystem south       = new SolarSystem();
        SolarSystem southWest   = new SolarSystem();
        SolarSystem northWest   = new SolarSystem();

        // Center Systems Planets
        galaxy.getCenter().addPlanet(new Planet(PlanetNames.MecatolRex));

        // North System Planets
        galaxy.getNorth().addPlanet(new Planet(PlanetNames.VegaMinor));
        galaxy.getNorth().addPlanet(new Planet(PlanetNames.VegaMajor));

        // South-East System Planets
        galaxy.getSouthEast().addPlanet(new Planet(PlanetNames.Industrex));

        // South System Planets
        galaxy.getSouth().addPlanet(new Planet(PlanetNames.RigelI));
        galaxy.getSouth().addPlanet(new Planet(PlanetNames.RigelII));

        // North-west System Planets
        galaxy.getNorthWest().addPlanet(new Planet(PlanetNames.Mirage));

        // Center System Units
        galaxy.getCenter().addShip(new Dreadnought(blue));
        galaxy.getCenter().addShip(new Dreadnought(blue));
        galaxy.getCenter().addShip(new Destroyer(blue));

        // North System Units
        galaxy.getNorth().addShip(new Cruiser(red));
        galaxy.getNorth().addShip(new Cruiser(red));
        galaxy.getNorth().addShip(new Carrier(red));

        return galaxy;
    }
}
