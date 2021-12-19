package com.nasdaq.elections.exceptions.handler;

import com.nasdaq.elections.exceptions.UserAlreadyVotedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GalaxyPresidentialElectionExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyVotedException.class)
    public ResponseEntity<Object> handleUserAlreadyVotedException(UserAlreadyVotedException e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException() {

        return new ResponseEntity<>("Unexpected error occurred, please check in with Galaxy Presidential Election " +
                "Support if service does not work at support@elections.galaxy",
                HttpStatus.BAD_REQUEST);
    }
}
