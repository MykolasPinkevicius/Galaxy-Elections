package com.nasdaq.elections.services;

import com.nasdaq.elections.business.response.OverallVotesDistributionByRegionResponse;
import com.nasdaq.elections.business.response.OverallVotesDistributionResponse;
import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.domain.Candidate;
import com.nasdaq.elections.domain.GalaxyRegion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ElectionServiceTest {

    private ElectionService electionService;
    private final int FIRST = 0;

    @Mock
    private BallotDao ballotDao;

    @BeforeEach
    public void setUp() {

        openMocks(this);
        electionService = new ElectionService(ballotDao);
    }

    @Test
    public void should_return_overall_votes_distribution_response() {

        // given
        long expected = 1;
        when(ballotDao.countByCandidate(any(Candidate.class))).thenReturn(expected);

        // when
        OverallVotesDistributionResponse overallVotesDistributionResponse = electionService.overallVotesDistribution();

        // then
        assertEquals(expected, overallVotesDistributionResponse.getCandidateResults().get(FIRST).getVotes());
    }

    @Test
    public void should_return_overall_votes_distribution_by_region_response() {

        // given
        long expected = 1;
        when(ballotDao.countByCandidateAndGalaxyRegion(Candidate.ADLAI_STEVENSON, GalaxyRegion.NUCLEUS))
                .thenReturn(expected);
        when(ballotDao.countByCandidateAndGalaxyRegion(Candidate.CHARLES_A_TOWNE, GalaxyRegion.NUCLEUS))
                .thenReturn(expected);

        // when
        OverallVotesDistributionByRegionResponse overallVotesDistributionByRegionResponse =
                electionService.overallVotesDistributionByRegionResponse();

        // then
        assertEquals(expected,
                overallVotesDistributionByRegionResponse.getRegionCandidatesResult().get(FIRST)
                        .getCandidatesResult().get(FIRST).getVotes());
    }
}
