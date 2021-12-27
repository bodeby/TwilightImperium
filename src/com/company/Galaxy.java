package com.company;

public class Galaxy {
    SolarSystem center;
    SolarSystem north;
    SolarSystem northEast;
    SolarSystem southEast;
    SolarSystem south;
    SolarSystem southWest;
    SolarSystem northWest;

    public Galaxy() {
        this.center = new SolarSystem();
        this.north = new SolarSystem();
        this.northEast = new SolarSystem();
        this.southEast = new SolarSystem();
        this.south = new SolarSystem();
        this.southWest = new SolarSystem();
        this.northWest = new SolarSystem();
    }

    public SolarSystem getCenter() {
        return center;
    }

    public SolarSystem getNorth() {
        return north;
    }

    public SolarSystem getNorthEast() {
        return northEast;
    }

    public SolarSystem getSouthEast() {
        return southEast;
    }

    public SolarSystem getSouth() {
        return south;
    }

    public SolarSystem getSouthWest() {
        return southWest;
    }

    public SolarSystem getNorthWest() {
        return northWest;
    }
}
