package com.company;

import com.company.Units.Unit;

import java.util.*;

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
        systems.forEach((key, value) -> value.getShips().forEach(ship -> {
            if (ship.getPlayer().equals(player)) {
                playerShips.add(ship);
            }}));

        // Sort ships by Combat values
        playerShips.sort((o1, o2) -> o2.getCombatValue() - o1.getCombatValue());
        playerShips.forEach(ship -> System.out.println(ship.toString()));

        // Returns List of Ships
        return playerShips;

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
}
