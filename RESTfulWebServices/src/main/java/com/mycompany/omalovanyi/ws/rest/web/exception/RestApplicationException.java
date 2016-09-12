package com.mycompany.omalovanyi.ws.rest.web.exception;

public class RestApplicationException extends RuntimeException {

    public RestApplicationException(String message) {
        super(message);
    }

    public RestApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestApplicationException(Throwable cause) {
        super(cause);
    }

    public RestApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RestApplicationException() {
    }
}
