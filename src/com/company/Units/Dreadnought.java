package com.company.Units;

import com.company.Player;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Dreadnought implements Unit {
    Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    public Dreadnought(Player player)  {
        this.player = player;
        this.resourceCost = 5;
        this.combatValue = 5;
        this.movementSpeed = 1;
        this.capacity = 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dreadnought{");
        sb.append(player.getColor());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int getResourceCost() {
        return resourceCost;
    }

    @Override
    public int getCombatValue() {
        return combatValue;
    }

    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
