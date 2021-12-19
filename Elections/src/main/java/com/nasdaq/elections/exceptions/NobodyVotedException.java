package com.nasdaq.elections.exceptions;

public class NobodyVotedException extends RuntimeException {

    private String message;

    public NobodyVotedException(String message) {

        super(message);
    }
}
