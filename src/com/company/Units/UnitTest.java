package com.company.Units;

import com.company.Player;
import com.company.PlayerEnums.HacanNames;
import com.company.PlayerEnums.LetnevNames;
import com.company.PlayerEnums.SolNames;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    Player testPlayer, testPlayer2;

    Carrier carrier;
    Cruiser cruiser;
    Destroyer destroyer;
    Dreadnought dreadnought;

    @BeforeEach
    public void setup() {
        // Test Players
        testPlayer = new Player(String.valueOf(HacanNames.Gila), "The Emirates of Hacan", "blue");
        testPlayer2 = new Player(String.valueOf(SolNames.DeLouis), "The Federation of Sol", "red");

        carrier = new Carrier(testPlayer);
        cruiser = new Cruiser(testPlayer);
        destroyer = new Destroyer(testPlayer);
        dreadnought = new Dreadnought(testPlayer);
    }

    @Test
    void getResourceCost() {
        assertEquals(carrier.getResourceCost(),3);
        assertEquals(cruiser.getResourceCost(), 2);
        assertEquals(destroyer.getResourceCost(), 1);
        assertEquals(dreadnought.getResourceCost(), 5);
    }

    @Test
    void getCombatValue() {
        assertEquals(carrier.getCombatValue(),9);
        assertEquals(cruiser.getCombatValue(), 7);
        assertEquals(destroyer.getCombatValue(), 9);
        assertEquals(dreadnought.getCombatValue(), 5);
    }

    @Test
    void getMovementSpeed() {
        assertEquals(carrier.getMovementSpeed(), 1);
        assertEquals(cruiser.getMovementSpeed(), 2);
        assertEquals(destroyer.getMovementSpeed(), 2);
        assertEquals(dreadnought.getMovementSpeed(), 1);
    }

    @Test
    void getCapacity() {
        assertEquals(carrier.getCapacity(), 6);
        assertEquals(cruiser.getCapacity(), 0);
        assertEquals(destroyer.getCapacity(),0);
        assertEquals(dreadnought.getCapacity(), 0);
    }

    @Test
    void getPlayer() {
        assertEquals(carrier.getPlayer(), testPlayer);
        assertEquals(cruiser.getPlayer(), testPlayer);

        assertNotEquals(destroyer.getPlayer(),testPlayer2);
        assertNotEquals(dreadnought.getPlayer(), testPlayer2);
    }
}