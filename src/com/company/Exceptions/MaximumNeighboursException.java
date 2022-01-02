package com.company.Exceptions;

public class MaximumNeighboursException extends RuntimeException {
    String msg;

    public MaximumNeighboursException(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
