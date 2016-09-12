package com.mycompany.omalovanyi.ws.rest.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Application Exception")
    @ExceptionHandler(RestApplicationException.class)
    public void restApplicationException() {
    }

}
