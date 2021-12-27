package com.company;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SolarSystemTest {

    Galaxy galaxy;
    SolarSystem center;
    SolarSystem north;
    SolarSystem south;

    @BeforeEach
    public void setup() {
        // Galaxy
        galaxy = new Galaxy();

        // Systems
        center      = new SolarSystem();
        north       = new SolarSystem();
        south       = new SolarSystem();

        // Central Systems Relations
        center.addNeighbour(north);
        north.addNeighbour(center);
    }


    @Test
    void addPlanet() {
        Planet mirage = new Planet(PlanetNames.Mirage);
        center.addPlanet(mirage);
        center.addPlanet(new Planet(PlanetNames.VegaMajor));
        center.addPlanet(new Planet(PlanetNames.RigelII));

        assertTrue(center.getPlanets().contains(mirage));
    }

    @Test
    void getPlanets() {
    }

    @Test
    void getShips() {
    }

    @Test
    void addNeighbour() {
        // Check for true
        assertTrue(center.getNeighbours().contains(north));
        assertTrue(north.getNeighbours().contains(center));

        // Check for false
        assertFalse(north.getNeighbours().contains(south));
    }

    @Test
    void addShip() {
    }
}