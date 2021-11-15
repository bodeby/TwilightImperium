package com.company;

import java.util.ArrayList;
import java.util.Set;

public class SolarSystem {
    Set<Planet> planets;
    ArrayList<Unit> ships;

    public SolarSystem(Set<Planet> planets, ArrayList<Unit> ships) {
        this.planets = planets;
        this.ships = ships;
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public ArrayList<Unit> getShips() {
        return ships;
    }

    public void addShip(Unit ship) {
        if (ships.size() < 3) {
            this.ships.add(ship);
        } else {
            System.out.println("SolarSystem can't have more than 3 planets");
        }
    }
}
