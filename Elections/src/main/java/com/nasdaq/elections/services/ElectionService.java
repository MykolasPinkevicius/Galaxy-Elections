package com.nasdaq.elections.services;

import com.nasdaq.elections.business.CandidateResult;
import com.nasdaq.elections.business.RegionCandidatesResult;
import com.nasdaq.elections.business.response.*;
import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.domain.Ballot;
import com.nasdaq.elections.domain.Candidate;
import com.nasdaq.elections.domain.GalaxyRegion;
import com.nasdaq.elections.exceptions.NobodyVotedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            if (((double) mostPopularCandidate.getVotes() / (double) ballotDao.count()) > 0.5D) {
                SingleCandidateElectionFinishResponse singleCandidateElectionFinishResponse =
                        new SingleCandidateElectionFinishResponse();
                singleCandidateElectionFinishResponse.setCandidateResult(mostPopularCandidate);
                return singleCandidateElectionFinishResponse;
            } else {
                MultipleCandidatesElectionFinishResponse multipleCandidatesElectionFinishResponse =
                        new MultipleCandidatesElectionFinishResponse();
                List<CandidateResult> winners = new ArrayList<>();
                winners.add(mostPopularCandidate);
                winners.add(candidateResults.get(second));
                multipleCandidatesElectionFinishResponse.setCandidateResult(winners);
                return multipleCandidatesElectionFinishResponse;
            }
        } else {
            throw new NobodyVotedException("Nobody voted on Galaxy Presidential Elections");
        }
    }

    private List<CandidateResult> processCandidates() {

        List<CandidateResult> candidateResults = new ArrayList<>();
        Arrays.asList(Candidate.values()).forEach(candidate -> processCandidate(candidateResults, candidate));
        Collections.sort(candidateResults);
        return candidateResults;
    }

    private void processCandidate(List<CandidateResult> candidateResults, Candidate candidate) {

        CandidateResult candidateResult = new CandidateResult();
        candidateResult.setCandidate(candidate);
        candidateResult.setVotes(ballotDao.countByCandidate(candidate));
        candidateResults.add(candidateResult);
    }

    private List<RegionCandidatesResult> processCandidatesByRegion() {

        List<RegionCandidatesResult> regionCandidatesResults = new ArrayList<>();
        Arrays.asList(GalaxyRegion.values()).forEach(galaxyRegion -> processRegionCandidates(regionCandidatesResults,
                galaxyRegion));
        return regionCandidatesResults;
    }

    private void processRegionCandidates(List<RegionCandidatesResult> regionCandidatesResults,
                                         GalaxyRegion galaxyRegion) {

        RegionCandidatesResult regionCandidatesResult = new RegionCandidatesResult();
        regionCandidatesResult.setGalaxyRegion(galaxyRegion);
        regionCandidatesResult.setCandidatesResult(processBallots(ballotDao.findAllByGalaxyRegion(galaxyRegion)));
        regionCandidatesResults.add(regionCandidatesResult);
    }

    private List<CandidateResult> processBallots(Iterable<Ballot> regionBallots) {

        List<CandidateResult> candidateResults = new ArrayList<>();
        regionBallots.forEach(ballot -> processBallot(candidateResults, ballot));
        return candidateResults;
    }

    private void processBallot(List<CandidateResult> candidateResults, Ballot ballot) {

        CandidateResult candidateResult = new CandidateResult();
        candidateResult.setCandidate(ballot.getCandidate());
        candidateResult.setVotes(ballotDao.countByCandidateAndGalaxyRegion(
                ballot.getCandidate(), ballot.getGalaxyRegion()));
        candidateResults.add(candidateResult);
    }
}
