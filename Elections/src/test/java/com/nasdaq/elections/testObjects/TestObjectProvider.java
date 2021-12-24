package com.nasdaq.elections.testObjects;

import com.nasdaq.elections.domain.Ballot;
import com.nasdaq.elections.domain.Candidate;
import com.nasdaq.elections.domain.GalaxyRegion;
import com.nasdaq.elections.domain.Voter;

import java.util.ArrayList;
import java.util.List;

public class TestObjectProvider {

    public static Voter getVoter(Long id) {

        Voter voter = new Voter();
        voter.setVoterId(id);
        voter.setBallot(getBallot(Candidate.CHARLES_A_TOWNE, 1L));
        return voter;
    }

    public static List<Ballot> getBallots() {

        return List.of(getBallot(Candidate.ADLAI_STEVENSON, 1L), getBallot(Candidate.CHARLES_A_TOWNE, 2L));
    }

    public static Ballot getBallot(Candidate candidate, Long id) {

        Ballot ballot = new Ballot();
        ballot.setCandidate(candidate);
        ballot.setGalaxyRegion(GalaxyRegion.NUCLEUS);
        ballot.setId(id);
        return ballot;
    }

    public static List<Ballot> getBallotsForSingleWinnerTest() {

        List<Ballot> ballots = new ArrayList<>();
        ballots.add(getBallot(Candidate.CHARLES_A_TOWNE, 1L));
        ballots.add(getBallot(Candidate.ADLAI_STEVENSON, 2L));
        ballots.add(getBallot(Candidate.ADLAI_STEVENSON, 3L));
        ballots.add(getBallot(Candidate.ELLIOT_DANFORTH, 4L));
        ballots.add(getBallot(Candidate.ADLAI_STEVENSON, 5L));
        return ballots;
    }

    public static List<Ballot> getBallotsForMultipleWinnersTest() {

        List<Ballot> ballots = new ArrayList<>();
        ballots.add(getBallot(Candidate.CHARLES_A_TOWNE, 1L));
        ballots.add(getBallot(Candidate.ADLAI_STEVENSON, 2L));
        ballots.add(getBallot(Candidate.ADLAI_STEVENSON, 3L));
        ballots.add(getBallot(Candidate.ELLIOT_DANFORTH, 4L));
        ballots.add(getBallot(Candidate.ELLIOT_DANFORTH, 5L));
        return ballots;
    }
}
