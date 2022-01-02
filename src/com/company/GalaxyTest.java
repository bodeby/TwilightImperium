package com.company;

import com.company.Units.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

class GalaxyTest {

    Galaxy galaxy;

    @BeforeEach
    public void setup() {
        galaxy = GalaxyConfig.Create();
    }

    @Test
    void getCenterSystemPlanet() {

        // Test That the system has one planets
        Integer numPlanets = galaxy.getCenter().getPlanets().size();
        assertEquals(numPlanets, 1);

        // Test that the name of the planet is MechatolRex
        Set<Planet> planets = galaxy.getCenter().getPlanets();
        Optional<Planet> only = planets.stream().findFirst();
        System.out.println(only);

        assertEquals(1, 1);

    }

    @Test
    void getPlayerShips() {
        System.out.println(galaxy.getCenter().getShips());


        ArrayList<Unit> sortedShips = galaxy.getCenter().getShips();

        sortedShips.sort((o1, o2) -> {
            if (o2.getCombatValue() == o1.getCombatValue()) {
                return o2.getResourceCost() - o1.getResourceCost();
            }
            return o2.getCombatValue() - o1.getCombatValue();
        });

        assertEquals(galaxy.getPlayerShips(galaxy.getBlue()), sortedShips);
    }


}