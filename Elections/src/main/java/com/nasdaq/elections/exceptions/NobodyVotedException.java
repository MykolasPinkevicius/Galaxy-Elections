package com.nasdaq.elections.exceptions;

public class NobodyVotedException extends RuntimeException {

    public NobodyVotedException(String message) {

        super(message);
    }
}
