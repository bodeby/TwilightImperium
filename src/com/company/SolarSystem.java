package com.company;

import com.company.Exceptions.MaximumNeighboursException;
import com.company.Exceptions.MaximumPlanetsException;
import com.company.Units.Unit;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class SolarSystem implements Iterable<Planet> {
    Set<Planet> planets;
    Set<String> neighbours;
    ArrayList<Unit> ships;
    Player controlledBy;


    public SolarSystem(Planet... planets) {
        this.planets = new HashSet<>();
        this.neighbours = new HashSet<>();
        this.ships = new ArrayList<>();
        this.controlledBy = new Player("Uncontrolled", "", "");

        //Collections.addAll(this.planets, planets);
        Arrays.stream(planets).toList().forEach(this::addPlanet);
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

    public Player getControlledBy() {
        return controlledBy;
    }

    public void setControlledBy(Player controlledBy) {
        // Output Change of control in any other scenario than uncontrolled to controlled
        if (!Objects.equals(this.controlledBy.getName(), "Uncontrolled")) {
            System.out.println("\n" + controlledBy.getColor() + " has taken control of this system\n");
        }

        this.controlledBy = controlledBy;
    }

    public void setShips(ArrayList<Unit> ships) {
        this.ships = ships;
    }


    // Method to add Planets to the system
    public void addPlanet(Planet planet) {
        if (planets.size() < 3) {
            this.planets.add(planet);
        } else {
            throw new MaximumPlanetsException("A system can't have more than 3 planets");
        }
    }

    // Method to add neighbours to the
    public void addNeighbour(String neighbour) {
        if (this.neighbours.size() <= 5) {
            this.neighbours.add(neighbour);
        } else {
            throw new MaximumNeighboursException("A system can't have more than 5 neighbouring systems");
        }
    }

    // Method to add Units to the System
    public void addShip(Unit ship) {
        this.ships.add(ship);
    }


    public void shipEnter(ArrayList<Unit> units) {
        // Add Units to Systems

        units.forEach(this::addShip);

        // Check the newly added Ships conflicts
        AtomicBoolean bluePresent = new AtomicBoolean(false);
        AtomicBoolean redPresent = new AtomicBoolean(false);

        this.getShips().forEach(unit -> {
            if (unit.getPlayer().getColor().equals("blue")) {
                bluePresent.set(true);
            } else if (unit.getPlayer().getColor().equals("red")) {
                redPresent.set(true);
            }
        });

        if (bluePresent.get() && redPresent.get()) {
            spaceBattle();
        } else {
            // No Conclict
            this.setControlledBy(this.getShips().get(0).getPlayer());
        }

    }


    public void spaceBattle() {
        int round = 1;
        boolean inBattle = true;

        // To register the Player hits each round
        AtomicInteger blueHits = new AtomicInteger();
        AtomicInteger redHits = new AtomicInteger();

        // Blue Units in this System
        ArrayList<Unit> blueShips = this.getShips()
                .stream()
                .filter(ship -> ship.getPlayer().getColor().equals("blue"))
                .collect(Collectors.toCollection(ArrayList::new));

        // Red Units in this System
        ArrayList<Unit> redShips = this.getShips()
                .stream()
                .filter(ship -> ship.getPlayer().getColor().equals("red"))
                .collect(Collectors.toCollection(ArrayList::new));

        // Sort Values by Resource Cost
        blueShips.sort((o1, o2) -> o2.getResourceCost() - o1.getResourceCost());
        redShips.sort(((o1, o2) -> o2.getResourceCost() - o1.getResourceCost()));

        // Simulate battle
        while (inBattle) {
            System.out.println("\nRound: " + round);
            round++;

            // Roll for Blue Hits
            blueShips.forEach(unit -> {
                if (Die.Roll() >= unit.getCombatValue()) {
                    blueHits.getAndIncrement();
                }
            });

            // Roll for Red Hits
            redShips.forEach(unit -> {
                if (Die.Roll() >= unit.getCombatValue()) {
                    redHits.getAndIncrement();
                }
            });

            System.out.println("Blue units: " + blueShips);
            System.out.println("Red units:  " + redShips);

            System.out.println("\nblue scored: " + blueHits + " hit(s) this round");
            System.out.println("red scored:  " + redHits + "  hit(s) this round\n");

            // Execute red ships based on Blue Hits
            for (int i = 0; i < blueHits.get(); i++) {
                if (redShips.size() != 0 && inBattle) {
                    System.out.println(redShips.get(redShips.size() - 1).toString() + " destroyed");
                    redShips.remove(redShips.size() - 1);
                } else {
                    inBattle = false;
                }
            }

            // Execute blue ships based on Red Hits
            for (int k = 0; k < redHits.get(); k++) {
                if (blueShips.size() != 0 && inBattle) {
                    System.out.println(blueShips.get(blueShips.size() - 1).toString() + " destroyed");
                    blueShips.remove(blueShips.size() - 1);
                } else {
                    inBattle = false;
                }
            }

            if (blueShips.size() == 0 && redShips.size() != 0) {
                setControlledBy(redShips.get(0).getPlayer());
                setShips(redShips);
            } else if (redShips.size() == 0 && blueShips.size() != 0) {
                setControlledBy(blueShips.get(0).getPlayer());
                setShips(blueShips);
            } else {
                System.out.printf("\nBlue has: %d units left\n", blueShips.size());
                System.out.printf("Red has:  %d units left\n", redShips.size());
            }
        }
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
        sb.append("\n  ruler=").append(controlledBy);
        sb.append("\n}");
        return sb.toString();
    }
}
