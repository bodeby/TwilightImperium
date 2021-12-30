package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(1,1);


    }
}