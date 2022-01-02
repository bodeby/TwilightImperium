package com.company.Exceptions;

public class InvalidCenterSystemException extends RuntimeException {
    String msg;

    public InvalidCenterSystemException (String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
