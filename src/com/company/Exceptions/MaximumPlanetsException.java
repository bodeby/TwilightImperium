package com.company.Exceptions;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class MaximumPlanetsException extends RuntimeException {
    String msg;

    public MaximumPlanetsException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
