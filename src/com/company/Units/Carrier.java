package com.company.Units;

import com.company.Player;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Carrier implements Unit {
    Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    public Carrier(Player player) {
        this.player = player;
        this.resourceCost = 3;
        this.combatValue = 9;
        this.movementSpeed = 1;
        this.capacity = 6;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cruiser{");
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
