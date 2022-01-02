package com.company;

import com.company.Exceptions.DuplcatePlanetException;
import com.company.Exceptions.InvalidCenterSystemException;
import com.company.Exceptions.MaximumPlanetsException;
import com.company.Units.Destroyer;
import com.company.Units.Dreadnought;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Twilight Imperium\n");

        //Galaxy galaxy = GalaxyConfig.Create();

        Galaxy testGalaxy = GalaxyGenerator.generate();

        try {
            testGalaxy.isValid();
        } catch (InvalidCenterSystemException e) {
            System.out.println(e.getMessage());
        } catch (DuplcatePlanetException e) {
            System.out.println(e.getMessage());
        } catch (MaximumPlanetsException e) {
            System.out.println(e.getMessage());
        }
    }
}
