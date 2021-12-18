package com.nasdaq.elections.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GalaxyPresidentialElectionExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException e) {

        return new ResponseEntity<>("Unexpected error occurred, please check in with Galaxy Presidential Election " +
                "Support if service does not work at support@elections.galaxy",
                HttpStatus.BAD_REQUEST);
    }
}
