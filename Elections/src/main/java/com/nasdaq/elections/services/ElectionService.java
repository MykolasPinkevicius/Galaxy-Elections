package com.nasdaq.elections.services;

import com.nasdaq.elections.business.CandidateResult;
import com.nasdaq.elections.business.RegionCandidatesResult;
import com.nasdaq.elections.business.response.*;
import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.domain.Candidate;
import com.nasdaq.elections.domain.GalaxyRegion;
import com.nasdaq.elections.exceptions.NobodyVotedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectionService {

    private final BallotDao ballotDao;

    public ElectionService(BallotDao ballotService) {

        this.ballotDao = ballotService;
    }

    public OverallVotesDistributionResponse overallVotesDistribution() {

        OverallVotesDistributionResponse overallVotesDistribution = new OverallVotesDistributionResponse();
        overallVotesDistribution.setCandidateResults(processCandidates());
        return overallVotesDistribution;
    }

    public OverallVotesDistributionByRegionResponse overallVotesDistributionByRegionResponse() {

        OverallVotesDistributionByRegionResponse overallVotesDistributionByRegionResponse =
                new OverallVotesDistributionByRegionResponse();
        overallVotesDistributionByRegionResponse.setRegionCandidatesResult(processCandidatesByRegion());
        return overallVotesDistributionByRegionResponse;
    }

    public ElectionFinishResponse finishElection() {

        int first = 0;
        int second = 1;

        List<CandidateResult> candidateResults = processCandidates();
        if (candidateResults.get(first).getVotes() > 0) {
            CandidateResult mostPopularCandidate = candidateResults.get(first);
            if (moreThanHalfVotesBy(mostPopularCandidate)) {
                return singleCandidateFinish(mostPopularCandidate);
            } else {
                return multipleCandidatesFinish(second, candidateResults, mostPopularCandidate);
            }
        } else {
            throw new NobodyVotedException("Nobody voted on Galaxy Presidential Elections");
        }
    }

    private boolean moreThanHalfVotesBy(CandidateResult mostPopularCandidate) {

        return ((double) mostPopularCandidate.getVotes() / (double) ballotDao.count()) > 0.5D;
    }

    private List<CandidateResult> processCandidates() {

        return Arrays.stream(Candidate.values()).map(this::processCandidate).sorted().collect(Collectors.toList());
    }

    private CandidateResult processCandidate(Candidate candidate) {

        CandidateResult candidateResult = new CandidateResult();
        candidateResult.setCandidate(candidate);
        candidateResult.setVotes(ballotDao.countByCandidate(candidate));
        return candidateResult;
    }

    private List<RegionCandidatesResult> processCandidatesByRegion() {

        return Arrays.stream(GalaxyRegion.values()).map(this::processRegionCandidates).collect(Collectors.toList());
    }

    private RegionCandidatesResult processRegionCandidates(GalaxyRegion galaxyRegion) {

        RegionCandidatesResult regionCandidatesResult = new RegionCandidatesResult();
        regionCandidatesResult.setGalaxyRegion(galaxyRegion);
        regionCandidatesResult.setCandidatesResult(processBallots(galaxyRegion));
        return regionCandidatesResult;
    }

    private List<CandidateResult> processBallots(GalaxyRegion galaxyRegion) {

        return Arrays.stream(Candidate.values()).map(candidate -> processCandidate(candidate, galaxyRegion))
                .collect(Collectors.toList());
    }

    private CandidateResult processCandidate(Candidate candidate,
                                             GalaxyRegion galaxyRegion) {

        CandidateResult candidateResult = new CandidateResult();
        candidateResult.setVotes(ballotDao.countByCandidateAndGalaxyRegion(candidate, galaxyRegion));
        candidateResult.setCandidate(candidate);
        return candidateResult;
    }

    private SingleCandidateElectionFinishResponse singleCandidateFinish(CandidateResult mostPopularCandidate) {

        SingleCandidateElectionFinishResponse singleCandidateElectionFinishResponse =
                new SingleCandidateElectionFinishResponse();
        singleCandidateElectionFinishResponse.setCandidateResult(mostPopularCandidate);
        return singleCandidateElectionFinishResponse;
    }

    private MultipleCandidatesElectionFinishResponse multipleCandidatesFinish
            (int second, List<CandidateResult> candidateResults, CandidateResult mostPopularCandidate) {

        MultipleCandidatesElectionFinishResponse multipleCandidatesElectionFinishResponse =
                new MultipleCandidatesElectionFinishResponse();
        List<CandidateResult> winners = new ArrayList<>();
        winners.add(mostPopularCandidate);
        winners.add(candidateResults.get(second));
        multipleCandidatesElectionFinishResponse.setCandidateResult(winners);
        return multipleCandidatesElectionFinishResponse;
    }
}
