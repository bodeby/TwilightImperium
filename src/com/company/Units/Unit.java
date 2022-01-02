package com.company.Units;

import com.company.Player;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public interface Unit {

    public int getResourceCost();

    public int getCombatValue();

    public int getMovementSpeed();

    public int getCapacity();

    public Player getPlayer();
}
