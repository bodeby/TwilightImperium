package com.company;

import com.company.Exceptions.DuplcatePlanetException;
import com.company.Exceptions.InvalidCenterSystemException;
import com.company.Exceptions.MaximumPlanetsException;
import com.company.Units.Unit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Galaxy {
    Player blue, red;
    Map<String, SolarSystem> systems;

    public Galaxy(Player blue, Player red, Map<String, SolarSystem> systemMap) {
        // Players in Galaxy
        this.blue = blue;
        this.red = red;
        this.systems = systemMap;
    }

    // Method that returns the string values of all systems in galaxy
    public void getGalaxyInfo() {
        systems.forEach((key, value) -> {
            System.out.printf("%s: %s\n\n", key, value.toString());
        });
    }

    public List<Unit> getPlayerShips(Player player) {

        System.out.printf("\nShips controlled by %s:\n", player.getName());

        // Iterate over each system and then each ship to determine
        // if the ship is owned by the requested Player
        List<Unit> playerShips = new ArrayList<>();
        this.systems.forEach((key, value) -> value.getShips().forEach(ship -> {
            if (ship.getPlayer().equals(player)) {
                playerShips.add(ship);
            }}));

        // Sort ships by Combat values
        playerShips.sort((o1, o2) -> o2.getCombatValue() - o1.getCombatValue());
        playerShips.forEach(ship -> System.out.printf("  %s\n", ship.toString()));

        // Returns List of Ships
        return playerShips;

    }

    // Problem 11 : Creates a .txt with list of players and planets they control
    public void getGalaxyStatus() {
        ArrayList<SolarSystem> RuledByBlue = new ArrayList<>();
        ArrayList<SolarSystem> RuledByRed = new ArrayList<>();
        ArrayList<SolarSystem> RuledByNone = new ArrayList<>();

        // iterate over systems in the galaxy
        this.systems.forEach((key, value) -> {
                switch (value.getControlledBy().getColor()) {
                    case "red" -> RuledByRed.add(value);
                    case "blue" -> RuledByBlue.add(value);
                    default -> RuledByNone.add(value);
                }
        });

        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("GameStatus.txt"));

            // Blue Players Planets
            output.write("\nBlue Player ("+ this.blue.getRace()+"):\n");
            RuledByBlue.forEach(system -> {
                if (system.getPlanets().size() > 0) {
                    system.getPlanets().forEach(planet -> {
                        try {
                            output.write("     " + planet.getName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            });

            // Red Players Planets
            output.write("\nRed Player ("+ this.red.getRace()+"):\n");
            RuledByRed.forEach(system -> {
                if (system.getPlanets().size() > 0) {
                    system.getPlanets().forEach(planet -> {
                        try {
                            output.write("     " + planet.getName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            });

            // Uncontrolled Planets
            output.write("\nUncontrolled planets:\n");
            RuledByNone.forEach(system -> {
                if (system.getPlanets().size() > 0) {
                    system.getPlanets().forEach(planet -> {
                        try {
                            output.write("     " + planet.getName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            });

            // Closes the writer
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }


    }

    public void isValid() {

        // 1.1 The center system must have exactly one planet named Mecatol Rex.
        if (this.getCenter().getPlanets().size() != 1) {
            throw new InvalidCenterSystemException("Center System must only contain 1 Planet");
        }

        // 1.2 Check MecatolRex is the only planet
        this.getCenter().getPlanets().forEach(planet -> {
            if (planet.getName() != PlanetNames.MecatolRex) {
                throw new InvalidCenterSystemException("Center Planet is not MecatolRex");
            }
        });

        // 2 Every planet belongs to at most one system.
        ArrayList<PlanetNames> taken_planets = new ArrayList<>();
        this.getSystems().forEach((key, value) -> value.getPlanets().forEach(planet -> {
            if (!taken_planets.contains(planet.getName())) {
                taken_planets.add(planet.getName());
            } else {
                throw new DuplcatePlanetException("Planet is present in more than one system");
            }
        }));

        // 3 Every system has at most three planets.
        this.getSystems().forEach((key, value) -> {
            if (value.getPlanets().size() > 3) {
                throw new MaximumPlanetsException("A system can't have more than 3 planets");
            }
        });

    }

    public Map<String, SolarSystem> getSystems() {
        return systems;
    }

    public SolarSystem getCenter() {
        return systems.get("Center");
    }

    public SolarSystem getNorth() {
        return systems.get("North");
    }

    public SolarSystem getNorthEast() {
        return systems.get("North-East");
    }

    public SolarSystem getSouthEast() {
        return systems.get("South-East");
    }

    public SolarSystem getSouth() {
        return  systems.get("South");
    }

    public SolarSystem getSouthWest() {
        return systems.get("South-West");
    }

    public SolarSystem getNorthWest() {
        return systems.get("North-West");
    }

    public Player getBlue() {
        return blue;
    }

    public Player getRed() {
        return red;
    }
}
