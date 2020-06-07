package com.scoquix.deepIT.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
        CustomErrorResponse response = new CustomErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setResponse(exc.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
