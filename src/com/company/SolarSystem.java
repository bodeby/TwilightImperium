package com.company;
import com.company.Units.Unit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SolarSystem {
    Set<Planet> planets;
    Set<SolarSystem> neighbours;
    ArrayList<Unit> ships;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SolarSystem = {");
        sb.append("\n   planets=").append(planets);
        sb.append("\n   neighbours=").append(neighbours);
        sb.append("\n   ships=").append(ships);
        sb.append("\n}");
        return sb.toString();
    }

    public SolarSystem() {
        this.planets = new HashSet<>();
        this.neighbours = new HashSet<>();
        this.ships = new ArrayList<>();
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public ArrayList<Unit> getShips() {
        return ships;
    }

    // Method to add Planets to the system
    public void addPlanet (Planet planet) {
        if (planets.size() < 3) {
            this.planets.add(planet);
        } else {
           System.out.println("A System can't have more than 3 planets");
        }
    }

    // Method to add neighbours to the system
    public void addNeighbour(SolarSystem neighbour) {
       if (this.neighbours.size() <= 5) {
           this.neighbours.add(neighbour);
       } else {
           System.out.println("A System can't have more than 6 Neighbours");
       }
    }

    public Set<SolarSystem> getNeighbours() {
        return neighbours;
    }

    // Method to add Units to the System
    public void addShip(Unit ship) {
        this.ships.add(ship);
    }
}
