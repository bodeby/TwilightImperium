package com.company;

import com.company.PlayerEnums.HacanNames;
import com.company.PlayerEnums.LetnevNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

class PlayerTest {

    Player testPlayer, testPlayer2;

    @BeforeEach
    public void setup() {
        // Test Players
        testPlayer = new Player(String.valueOf(HacanNames.Gila), "The Emirates of Hacan", "blue");
        testPlayer2 = new Player(String.valueOf(LetnevNames.Unlenn), "The Barony of Letnev", "red");
    }

    @Test
    void testEquals() {
        // Test Equals on test players
        assertTrue(testPlayer.equals(testPlayer));
        assertFalse(testPlayer.equals(testPlayer2));
    }

    @Test
    void getName() {

        String name = String.valueOf(HacanNames.Gila);
        assertEquals(testPlayer.getName(), name);

        String testName = String.valueOf(HacanNames.Carth);
        assertNotEquals(testPlayer.getName(), testName);
    }

    @Test
    void setName() {

        assertEquals(testPlayer.getName(), String.valueOf(HacanNames.Gila));

        testPlayer.setName(String.valueOf(HacanNames.Carth));
        assertEquals(testPlayer.getName(), String.valueOf(HacanNames.Carth));
    }

    @Test
    void getRace() {

        String race = "The Emirates of Hacan";
        String testRace = "The Federation of Sol";

        assertEquals(testPlayer.getRace(), race);
        assertNotEquals(testPlayer.getRace(), testRace);
    }

    @Test
    void setRace() {

        String race = "The Emirates of Hacan";
        String testRace = "The Federation of Sol";

        assertEquals(testPlayer.getRace(), race);

        testPlayer.setRace(testRace);

        assertEquals(testPlayer.getRace(), testRace);
        assertNotEquals(testPlayer.getRace(), race);
    }

    @Test
    void getColor() {

        String color = "blue";
        String testColor = "pink";

        assertEquals(testPlayer.getColor(), color);
        assertNotEquals(testPlayer.getColor(), testColor);
    }

    @Test
    void setColor() {

        String color = "blue";
        String testColor = "pink";

        assertEquals(testPlayer.getColor(), color);

        testPlayer.setColor(testColor);
        assertEquals(testPlayer.getColor(), testColor);
        assertNotEquals(testPlayer.getColor(), color);
    }
}