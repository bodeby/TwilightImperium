package com.company.Units;

import com.company.Player;

public class Carrier implements Unit {
    Player player;
    int resourceCost;
    int combatValue;
    int movementSpeed;
    int capacity;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Carrier{");
        sb.append("combatValue=").append(this.getCombatValue());
        sb.append(", ResourceCost=").append(this.getResourceCost());
        sb.append(", player=").append(player.getColor());
        sb.append('}');
        return sb.toString();
    }

    public Carrier(Player player) {
        this.player = player;
        this.resourceCost = 3;
        this.combatValue = 9;
        this.movementSpeed = 1;
        this.capacity = 6;
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
