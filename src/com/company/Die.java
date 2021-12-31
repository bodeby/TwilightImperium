package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    public static int Roll() {
        return ThreadLocalRandom.current().nextInt(1,10);
    }
}
