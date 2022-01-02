package com.company.Exceptions;

public class DuplcatePlanetException extends RuntimeException {
    String msg;

    public DuplcatePlanetException (String msg) { this.msg = msg;}

    public String getMessage() {
        return msg;
    }
}
