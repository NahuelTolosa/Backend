package com.app.app.handle;

public class AppException extends Exception {

    private String message;

    public AppException(String message) {
        super(message);
    }

}
