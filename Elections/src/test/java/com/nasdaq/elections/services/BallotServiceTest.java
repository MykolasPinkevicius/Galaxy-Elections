package com.nasdaq.elections.services;

import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.domain.Ballot;
import com.nasdaq.elections.testObjects.TestObjectProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class BallotServiceTest {

    private BallotService ballotService;
    @Mock
    private BallotDao ballotDao;

    @BeforeEach
    public void setUp() {

        openMocks(this);
        ballotService = new BallotService(ballotDao);
    }

    @Test
    public void should_return_all_ballots() {

        // given
        List<Ballot> expectedBallots = TestObjectProvider.getBallots();

        // when
        when(ballotDao.findAll()).thenReturn(expectedBallots);
        List<Ballot> actualBallots = ballotService.findAll();

        // then
        assertEquals(expectedBallots, actualBallots);
    }
}
