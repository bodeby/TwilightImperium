package com.company.Units;

import com.company.Player;

public class Destroyer implements Unit {
    Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Destroyer{");
        sb.append("player=").append(player);
        sb.append('}');
        return sb.toString();
    }

    public Destroyer(Player player) {
        this.player = player;
        this.resourceCost = 1;
        this.combatValue = 9;
        this.movementSpeed = 2;
        this.capacity = 0;
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
