package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Twilight Imperium");

        Galaxy galaxy = GalaxyConfig.Create();

        // Displaying all Solar Systems in Galaxy
        System.out.println("\nCenter: " + galaxy.getCenter().toString());
        System.out.println("\nNorth: " + galaxy.getNorth().toString());
        System.out.println("\nNorth-East: " + galaxy.getNorthEast().toString());
        System.out.println("\nSouth-East: " + galaxy.getSouthEast().toString());
        System.out.println("\nSouth: " + galaxy.getSouth().toString());
        System.out.println("\nSouth-West: " + galaxy.getSouthWest().toString());
        System.out.println("\nNorth-West: " + galaxy.getNorthWest().toString());
    }
}
