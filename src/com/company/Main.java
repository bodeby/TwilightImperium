package com.company;

import com.company.Exceptions.DuplcatePlanetException;
import com.company.Exceptions.InvalidCenterSystemException;
import com.company.Exceptions.MaximumPlanetsException;
import com.company.PlayerEnums.LetnevNames;
import com.company.PlayerEnums.SolNames;
import com.company.Units.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Twilight Imperium\n");

        // 1: Class to represent Player

        Player demoPlayer = new Player(String.valueOf(LetnevNames.Unlenn), "The Barony of Letnev", "blue");
        Player demoPlayer2 = new Player(String.valueOf(SolNames.DeLouis), "The Federation of Sol", "red");


        // 2: Unit Interface
        Unit demoUnit = new Destroyer(demoPlayer);
        System.out.println("\nDemo Unit: " + demoUnit);


        // 3: Classes to extend Interface

        Carrier demoCarrier = new Carrier(demoPlayer);
        Cruiser demoCruiser = new Cruiser(demoPlayer);
        Destroyer demoDestroyer = new Destroyer(demoPlayer);
        Dreadnought demoDreadnought = new Dreadnought(demoPlayer);

        // 3a : Demo only
        ArrayList<Unit> demoUnits = new ArrayList<>();
        demoUnits.add(demoCarrier);
        demoUnits.add(demoCruiser);
        demoUnits.add(demoDestroyer);
        demoUnits.add(demoDreadnought);



        // 4: Class to represent a Planet

        Planet demoPlanet = new Planet(PlanetNames.Mirage);


        // 5: class to represent a system, a: enter and b: all ships in system

        SolarSystem demoSystem = new SolarSystem(demoPlanet);

        // - a: Enter system
        demoSystem.shipEnter(demoUnits);

        // - b: retrieve all ships
        ArrayList<Unit> retrievedUnits = demoSystem.getShips();
        System.out.println("\nRetrieved Units: " + retrievedUnits);

        // 6: Galaxy, and methods to get All systems, ships, planets

        Map<String, SolarSystem> demoSystemMap = new HashMap<>();
        demoSystemMap.put("Center", demoSystem);

        Galaxy demoGalaxy = new Galaxy(demoPlayer, demoPlayer2, demoSystemMap);


        // - get all galaxy information
        demoGalaxy.getGalaxyInfo();


        // 7: Create Galaxy from predefined configuration
        Galaxy galaxy = GalaxyConfig.Create();

        // 9: Verify Galaxy Properties

        try {
            galaxy.isValid();
        } catch (InvalidCenterSystemException e) {
            System.out.println(e.getMessage());
        } catch (DuplcatePlanetException e) {
            System.out.println(e.getMessage());
        } catch (MaximumPlanetsException e) {
            System.out.println(e.getMessage());
        }

        // 10: Return all ships owned by a player in the Galaxy

        galaxy.getNorth().addShip(new Carrier(galaxy.getBlue()));
        galaxy.getNorth().addShip(new Destroyer(galaxy.getBlue()));
        galaxy.getNorth().addShip(new Cruiser(galaxy.getBlue()));

        galaxy.getPlayerShips(galaxy.getBlue());
        galaxy.getPlayerShips(galaxy.getRed());

        // 11: creates a text file containing a list of players
        galaxy.getGalaxyStatus();

        // 12: Create Galaxy from Generator
        Galaxy randomGalaxy = GalaxyGenerator.generate();

        randomGalaxy.getGalaxyInfo();

        // 13: resolve space combat in a system

        // - Using system.spaceBattle()


        Cruiser p2Cruiser = new Cruiser(demoPlayer2);
        Destroyer p2Destroyer = new Destroyer(demoPlayer2);

        demoSystem.addShip(p2Cruiser);
        demoSystem.addShip(p2Destroyer);
        demoSystem.spaceBattle();

        // - Entering Enemy controlled system

        /*
         ArrayList<Unit> p2Units = new ArrayList<>();
         p2Units.add(p2Cruiser);
         p2Units.add(p2Destroyer);
         demoSystem.shipEnter(p2Units);
         */
    }
}
