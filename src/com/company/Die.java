package com.company;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class Die {
    public static int Roll() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
