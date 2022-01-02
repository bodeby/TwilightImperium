package com.company;

import com.company.PlayerEnums.HacanNames;
import com.company.PlayerEnums.LetnevNames;
import com.company.PlayerEnums.SolNames;
import com.company.Units.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class GalaxyGenerator {
    public static Galaxy generate() {

        // Players
        Player blue, red;

        // Track Which races are taken
        ArrayList<String> takenRaces = new ArrayList<>();

        // Blue Player Information
        String blueRace = RaceGenerator();
        takenRaces.add(blueRace);
        String blueName = NameGenerator(blueRace);

        // Red Player Information
        String redRace = RaceGenerator();
        while (takenRaces.contains(redRace)) {
            redRace = RaceGenerator();
        }
        String redName = NameGenerator(redRace);

        // Initialize Players
        blue = new Player(blueName, blueRace, "blue");
        red = new Player(redName, redRace, "red");


        // Track Which planet names are taken
        ArrayList<PlanetNames> takenPlanets = new ArrayList<>();
        takenPlanets.add(PlanetNames.MecatolRex);

        // Generate Random number of planets in the galaxy, min: 3
        int numberOfPlanets = ThreadLocalRandom.current().nextInt(3, PlanetNames.values().length);

        // Track Which planets have been created
        ArrayList<Planet> planets = new ArrayList<>();

        // Generate available planets
        for (int i = 0; i < numberOfPlanets; i++) {
            PlanetNames name = PlanetNames.values()[ThreadLocalRandom.current().nextInt(0, PlanetNames.values().length)];
            while (takenPlanets.contains(name)) {
                name = PlanetNames.values()[ThreadLocalRandom.current().nextInt(0, PlanetNames.values().length)];
            }

            // Create Planet with name and add to list of used
            planets.add(new Planet(name));
            takenPlanets.add(name);

        }

        Map<String, SolarSystem> systemMap = new HashMap<>();
        systemMap.put("Center", new SolarSystem(new Planet(PlanetNames.MecatolRex)));
        systemMap.put("North", new SolarSystem());
        systemMap.put("North-East", new SolarSystem());
        systemMap.put("South-East", new SolarSystem());
        systemMap.put("South", new SolarSystem());
        systemMap.put("South-West", new SolarSystem());
        systemMap.put("North-West", new SolarSystem());

        ArrayList<String> systemKeys = new ArrayList<>();
        systemKeys.add("North");
        systemKeys.add("North-East");
        systemKeys.add("South-East");
        systemKeys.add("South");
        systemKeys.add("South-West");
        systemKeys.add("North-West");


        while (planets.size() != 0) {
            // Random Index
            int random = ThreadLocalRandom.current().nextInt(0, systemKeys.size() - 1);

            // If the system have less than 3 planets
            if (systemMap.get(systemKeys.get(random)).getPlanets().size() != 3) {

                // addPlanet to planet to system and remove planet from planet list
                systemMap.get(systemKeys.get(random)).addPlanet(planets.get(planets.size() - 1));
                planets.remove(planets.size() - 1);
            }
        }

        // Galaxy
        Galaxy galaxy = new Galaxy(blue, red, systemMap);

        // Central Systems Relations
        Arrays.asList("North", "North-East", "South-East", "South", "South-West", "North-West").forEach(galaxy.getCenter()::addNeighbour);

        // Northern System Relations
        Arrays.asList("Center", "North-East", "North-West").forEach(galaxy.getNorth()::addNeighbour);

        // North-Eastern System Relations
        Arrays.asList("Center", "North", "South-East").forEach(galaxy.getNorthEast()::addNeighbour);

        // South-Eastern System Relations
        Arrays.asList("Center", "North-East", "South").forEach(galaxy.getSouthEast()::addNeighbour);

        // Southern System Relations
        Arrays.asList("Center", "South-East", "South-West").forEach(galaxy.getSouth()::addNeighbour);

        // South-Western System Relations
        Arrays.asList("Center", "South", "North-West").forEach(galaxy.getSouthWest()::addNeighbour);

        // North-Western System Relations
        Arrays.asList("Center", "South-West", "North").forEach(galaxy.getNorthWest()::addNeighbour);


        // Generate Random units
        int startingUnits = ThreadLocalRandom.current().nextInt(2, 4);

        ArrayList<Unit> blueUnits = new ArrayList<>();
        ArrayList<Unit> redUnits = new ArrayList<>();

        for (int i = 0; i < startingUnits; i++) {
            blueUnits.add(unitGenerator(blue));
            redUnits.add(unitGenerator(red));
        }

        // Pick a random starting system
        int blueStartIndex, redStartIndex;
        blueStartIndex = ThreadLocalRandom.current().nextInt(1, systemKeys.size());
        redStartIndex = ThreadLocalRandom.current().nextInt(1, systemKeys.size());

        while (redStartIndex == blueStartIndex) {
            redStartIndex = ThreadLocalRandom.current().nextInt(1, systemKeys.size());
        }

        // Place blue's units in the chosen system
        systemMap.get(systemKeys.get(blueStartIndex)).setControlledBy(blue);
        blueUnits.forEach(unit -> {
            systemMap.get(systemKeys.get(blueStartIndex)).addShip(unit);
        });

        // Place red's units in the chosen system
        systemMap.get(systemKeys.get(blueStartIndex)).setControlledBy(red);
        int finalRedStartIndex = redStartIndex;
        redUnits.forEach(unit -> {
            systemMap.get(systemKeys.get(finalRedStartIndex)).addShip(unit);
        });

        return galaxy;
    }

    public static String RaceGenerator() {

        ArrayList<String> races = new ArrayList<>();
        races.add("The Barony of Letnev");
        races.add("The Emirates of Hacan");
        races.add("The Federation of Sol");

        int selection = ThreadLocalRandom.current().nextInt(0, races.size());
        return races.get(selection);
    }


    public static String NameGenerator(String race) {
        String name;

        switch (race) {
            case "The Barony of Letnev" -> name = String.valueOf(LetnevNames.values()[ThreadLocalRandom.current().nextInt(0, 2)]);
            case "The Emirates of Hacan" -> name = String.valueOf(HacanNames.values()[ThreadLocalRandom.current().nextInt(0, 2)]);
            case "The Federation of Sol" -> name = String.valueOf(SolNames.values()[ThreadLocalRandom.current().nextInt(0, 2)]);
            default -> name = "Thanos";
        }

        return name;
    }


    public static Unit unitGenerator(Player player) {
        Unit unit;
        int selector = ThreadLocalRandom.current().nextInt(0, 3);

        switch (selector) {
            case 1 -> unit = new Carrier(player);
            case 2 -> unit = new Cruiser(player);
            case 3 -> unit = new Destroyer(player);
            default -> unit = new Dreadnought(player);
        }

        return unit;
    }
}
