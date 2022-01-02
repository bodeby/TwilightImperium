package com.company;

import com.company.Units.Carrier;
import com.company.Units.Cruiser;
import com.company.Units.Destroyer;
import com.company.Units.Dreadnought;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class GalaxyConfig {
    public static Galaxy Create() {
        // Test Players
        Player blue = new Player("Crassus", "The Emirates of Hacan", "blue");
        Player red = new Player("Pompey", "Federation of Sol", "red");

        // Systems Planets
        Planet MecatolRex = new Planet(PlanetNames.MecatolRex);   // Center
        Planet VegaMinor = new Planet(PlanetNames.VegaMinor);    // North
        Planet VegaMajor = new Planet(PlanetNames.VegaMajor);    // North
        Planet Industrex = new Planet(PlanetNames.Industrex);    // South-East
        Planet RigelI = new Planet(PlanetNames.RigelI);       // South
        Planet RigelII = new Planet(PlanetNames.RigelII);      // South
        Planet Mirage = new Planet(PlanetNames.Mirage);       // North-West

        // Systems
        SolarSystem center = new SolarSystem(MecatolRex);
        SolarSystem north = new SolarSystem(VegaMinor, VegaMajor);
        SolarSystem northEast = new SolarSystem();
        SolarSystem southEast = new SolarSystem(Industrex);
        SolarSystem south = new SolarSystem(RigelI, RigelII);
        SolarSystem southWest = new SolarSystem();
        SolarSystem northWest = new SolarSystem(Mirage);

        Map<String, SolarSystem> systemMap = new HashMap<>();
        systemMap.put("Center", center);
        systemMap.put("North", north);
        systemMap.put("North-East", northEast);
        systemMap.put("South-East", southEast);
        systemMap.put("South", south);
        systemMap.put("South-West", southWest);
        systemMap.put("North-West", northWest);

        // Systems List

        // Galaxy
        Galaxy galaxy = new Galaxy(blue, red, systemMap);

        // Central Systems Relations
        Arrays.asList("North", "North-East", "South-East", "South", "South-West", "North-West").forEach(center::addNeighbour);

        // Northern System Relations
        Arrays.asList("Center", "North-East", "North-West").forEach(north::addNeighbour);

        // North-Eastern System Relations
        Arrays.asList("Center", "North", "South-East").forEach(northEast::addNeighbour);

        // South-Eastern System Relations
        Arrays.asList("Center", "North-East", "South").forEach(southEast::addNeighbour);

        // Southern System Relations
        Arrays.asList("Center", "South-East", "South-West").forEach(south::addNeighbour);

        // South-Western System Relations
        Arrays.asList("Center", "South", "North-West").forEach(southWest::addNeighbour);

        // North-Western System Relations
        Arrays.asList("Center", "South-West", "North").forEach(northWest::addNeighbour);

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
