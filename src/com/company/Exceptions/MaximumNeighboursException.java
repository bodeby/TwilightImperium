package com.company.Exceptions;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class MaximumNeighboursException extends RuntimeException {
    String msg;

    public MaximumNeighboursException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
