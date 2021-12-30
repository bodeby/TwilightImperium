package com.company;
import com.company.Units.Unit;
import java.util.*;

public class SolarSystem implements Iterable<Planet> {
    Set<Planet> planets;
    Set<String> neighbours;
    ArrayList<Unit> ships;

    public SolarSystem(Planet... planets) {
        this.planets = new HashSet<>();
        this.neighbours = new HashSet<>();
        this.ships = new ArrayList<>();

        Collections.addAll(this.planets, planets);
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public Set<String> getNeighbours() {
        return neighbours;
    }

    public ArrayList<Unit> getShips() {
        return ships;
    }

    // Method to add Planets to the system
    // TODO: Rewrite method to check for validity
    public void addPlanet (Planet planet) {
        if (planets.size() < 3) {
            this.planets.add(planet);
        } else {
           System.out.println("A System can't have more than 3 planets");
        }
    }

    // Method to add neighbours to the
    public void addNeighbour(String neighbour) {
       if (this.neighbours.size() <= 5) {
           this.neighbours.add(neighbour);
       } else {
           System.out.println("A System can't have more than 6 Neighbours");
       }
    }

    // Method to add Units to the System
    public void addShip(Unit ship) {
        this.ships.add(ship);
    }

    @Override
    public Iterator<Planet> iterator() {
        return planets.iterator();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SolarSystem {");
        sb.append("\n  planets=").append(planets);
        sb.append("\n  neighbours=").append(neighbours);
        sb.append("\n  ships=").append(ships);
        sb.append("\n}");
        return sb.toString();
    }
}
