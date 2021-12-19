package com.nasdaq.elections.business;

import com.nasdaq.elections.domain.Candidate;

public class CandidateResult implements Comparable<CandidateResult> {

    private Candidate candidate;
    private Long votes;

    public Candidate getCandidate() {

        return candidate;
    }

    public void setCandidate(Candidate candidate) {

        this.candidate = candidate;
    }

    public Long getVotes() {

        return votes;
    }

    public void setVotes(Long votes) {

        this.votes = votes;
    }

    @Override
    public int compareTo(CandidateResult o) {

        return Long.compare(o.votes, this.votes);
    }
}
