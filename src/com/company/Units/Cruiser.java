package com.company.Units;

import com.company.Player;

public class Cruiser implements Unit {
    Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cruiser{");
        sb.append("player=").append(player);
        sb.append('}');
        return sb.toString();
    }

    public Cruiser(Player player) {
        this.player = player;
        this.resourceCost = 2;
        this.combatValue = 7;
        this.movementSpeed = 2;
        this.capacity = 0;
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