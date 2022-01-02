package com.company.Exceptions;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class DuplcatePlanetException extends RuntimeException {
    String msg;

    public DuplcatePlanetException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
