package com.company.Units;

import com.company.Player;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Destroyer implements Unit {
    Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    public Destroyer(Player player) {
        this.player = player;
        this.resourceCost = 1;
        this.combatValue = 9;
        this.movementSpeed = 2;
        this.capacity = 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Destroyer{");
        sb.append(player.getColor());
        sb.append('}');
        return sb.toString();
    }

    public Player getPlayer() {
        return player;
    }

    public int getResourceCost() {
        return resourceCost;
    }

    public int getCombatValue() {
        return combatValue;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getCapacity() {
        return capacity;
    }
}
