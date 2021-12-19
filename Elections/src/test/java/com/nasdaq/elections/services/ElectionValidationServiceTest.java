package com.nasdaq.elections.services;

import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.exceptions.NobodyVotedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

public class ElectionValidationServiceTest {

    private ElectionService electionService;

    @Mock
    private BallotDao ballotDao;

    @BeforeEach
    public void setUp() {

        openMocks(this);
        electionService = new ElectionService(ballotDao);
    }

    @Test
    public void should_throw_nobody_voted_exception() {

        // then
        Assertions.assertThrows(NobodyVotedException.class, () -> electionService.finishElection());
    }
}
