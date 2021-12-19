package com.nasdaq.elections.services;

import com.nasdaq.elections.business.response.ElectionFinishResponse;
import com.nasdaq.elections.business.response.MultipleCandidatesElectionFinishResponse;
import com.nasdaq.elections.business.response.SingleCandidateElectionFinishResponse;
import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.domain.Ballot;
import com.nasdaq.elections.testObjects.TestObjectProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class WinnerTest {

    @Autowired
    private ElectionService electionService;

    @Autowired
    private BallotDao ballotDao;

    @Test
    public void should_return_single_candidate_election_finish_response() {

        // given
        List<Ballot> ballots = TestObjectProvider.getBallotsForSingleWinnerTest();
        ballotDao.saveAll(ballots);

        // when
        ElectionFinishResponse electionFinishResponse = electionService.finishElection();

        // then
        assertTrue(electionFinishResponse instanceof SingleCandidateElectionFinishResponse);
    }

    @Test
    public void should_return_multiple_winners() {

        // given
        List<Ballot> ballots = TestObjectProvider.getBallotsForMultipleWinnersTest();
        ballotDao.saveAll(ballots);

        // when
        ElectionFinishResponse electionFinishResponse = electionService.finishElection();

        // then
        assertTrue(electionFinishResponse instanceof MultipleCandidatesElectionFinishResponse);
    }
}
