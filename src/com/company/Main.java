package com.company;

import com.company.Units.Carrier;
import com.company.Units.Dreadnought;
import com.company.Units.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        java.lang.System.out.println("Twilight");

        Galaxy galaxy = GalaxyConfig.Create();

        System.out.println(galaxy.getNorth().getPlanets());
        System.out.println(galaxy.getNorth().getShips());
    }
}
