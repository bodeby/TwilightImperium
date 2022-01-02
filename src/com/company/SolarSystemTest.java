package com.company;
import com.company.Exceptions.MaximumPlanetsException;
import com.company.PlayerEnums.HacanNames;
import com.company.PlayerEnums.LetnevNames;
import com.company.Units.Cruiser;
import com.company.Units.Destroyer;
import com.company.Units.Unit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

// https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions

class SolarSystemTest {

    Galaxy galaxy;
    SolarSystem center, north, south;
    Player testPlayer, testPlayer2;

    @BeforeEach
    public void setup() {
        // Galaxy

        // Test Players
        testPlayer = new Player(String.valueOf(HacanNames.Gila), "The Emirates of Hacan", "blue");
        testPlayer2 = new Player(String.valueOf(LetnevNames.Unlenn), "The Barony of Letnev", "red");

        // Galaxy initialization
        Map<String, SolarSystem> systemMap = new HashMap<>();

        // Systems
        center      = new SolarSystem();
        north       = new SolarSystem();
        south       = new SolarSystem();

        systemMap.put("Center", center);
        systemMap.put("North", north);
        systemMap.put("South", south);

        galaxy = new Galaxy(testPlayer, testPlayer2, systemMap);

        // Central Systems Relations
        center.addNeighbour("North");
        north.addNeighbour("Center");
    }


    @Test
    void addPlanet() {
        Planet mirage = new Planet(PlanetNames.Mirage);

        center.addPlanet(mirage);
        center.addPlanet(new Planet(PlanetNames.VegaMajor));
        center.addPlanet(new Planet(PlanetNames.RigelII));

        MaximumPlanetsException exception = assertThrows(
                MaximumPlanetsException.class,
                () -> center.addPlanet(new Planet(PlanetNames.HopesEnd))
        );

        assertEquals("A system can't have more than 3 planets", exception.getMessage());

        assertTrue(center.getPlanets().contains(mirage));
        assertFalse(center.getPlanets().contains(new Planet(PlanetNames.Velnor)));
    }

    @Test
    void getPlanets() {

        Planet mirage = new Planet(PlanetNames.Mirage);
        center.addPlanet(mirage);

        assertTrue(center.getPlanets().contains(mirage));
        assertFalse(center.getPlanets().contains(new Planet(PlanetNames.Velnor)));

    }

    @Test
    void getShips() {

        ArrayList<Unit> ships = new ArrayList<Unit>();

        ships.add(new Destroyer(testPlayer));
        ships.add(new Cruiser(testPlayer));

        assertEquals(0, center.getShips().size());

        center.shipEnter(ships);

        assertEquals(center.getShips(), ships);
    }

    @Test
    void addNeighbour() {

        assertTrue(center.getNeighbours().contains("North"));

        assertFalse(center.getNeighbours().contains("South"));
        center.addNeighbour("South");

        assertTrue(center.getNeighbours().contains("South"));
    }

    @Test
    void addShip() {

        Destroyer ship = new Destroyer(testPlayer);

        assertFalse(center.getShips().contains(ship));

        center.addShip(ship);

        assertTrue(center.getShips().contains(ship));
    }
}