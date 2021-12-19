package com.nasdaq.elections.services;

import com.nasdaq.elections.exceptions.NobodyVotedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ElectionValidationServiceTest {

    @Autowired
    private ElectionService electionService;

    @Test
    public void should_throw_nobody_voted_exception() {

        // then
        Assertions.assertThrows(NobodyVotedException.class, () -> electionService.finishElection());
    }
}
