package com.company.Exceptions;

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
