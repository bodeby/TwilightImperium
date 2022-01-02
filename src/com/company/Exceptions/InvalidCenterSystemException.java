package com.company.Exceptions;

/*
 * Name: Frederik Bode Thorbensen
 * AAU-Mail: fthorb20@student.aau.dk
 */

public class InvalidCenterSystemException extends RuntimeException {
    String msg;

    public InvalidCenterSystemException (String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
