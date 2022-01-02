package com.company;

import com.company.PlayerEnums.HacanNames;
import com.company.PlayerEnums.LetnevNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

class PlanetTest {

    Planet testPlanet;

    @BeforeEach
    public void setup() {
        // Test Planet
        testPlanet = new Planet(PlanetNames.HopesEnd);
    }

    @Test
    void getName() {
        assertEquals(testPlanet.getName(), PlanetNames.HopesEnd);
        assertNotEquals(testPlanet.getName(), PlanetNames.MecatolRex);
    }

    @Test
    void getResourceProduction() {
        assertTrue(testPlanet.getResourceProduction() < 6);
        assertTrue(testPlanet.getResourceProduction() > 0);

        assertFalse(testPlanet.getResourceProduction() > 6);
        assertFalse(testPlanet.getResourceProduction() < 0);
    }
}