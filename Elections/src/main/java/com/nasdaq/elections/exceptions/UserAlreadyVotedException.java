package com.nasdaq.elections.exceptions;

public class UserAlreadyVotedException extends RuntimeException {

    public UserAlreadyVotedException(String message) {

        super(message);
    }
}
