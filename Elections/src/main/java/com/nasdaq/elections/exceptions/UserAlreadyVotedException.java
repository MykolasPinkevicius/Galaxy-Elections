package com.nasdaq.elections.exceptions;

public class UserAlreadyVotedException extends RuntimeException {

    private String message;

    public UserAlreadyVotedException(String message) {

        super(message);
    }
}
