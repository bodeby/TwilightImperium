package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Planet {
    PlanetNames name;
    int resourceProduction;

    public Planet(PlanetNames name) {
        this.name = name;
        this.resourceProduction = ThreadLocalRandom.current().nextInt(0,6);
    }

    public PlanetNames getName() {
        return name;
    }

    public int getResourceProduction() {
        return resourceProduction;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name=" + name +
                ", resourceProduction=" + resourceProduction +
                '}';
    }
}
