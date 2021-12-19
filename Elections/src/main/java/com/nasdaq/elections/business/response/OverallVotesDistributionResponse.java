package com.nasdaq.elections.business.response;

import com.nasdaq.elections.business.CandidateResult;

import java.util.List;

public class OverallVotesDistributionResponse {

    private List<CandidateResult> candidateResults;

    public List<CandidateResult> getCandidateResults() {

        return candidateResults;
    }

    public void setCandidateResults(List<CandidateResult> candidateResults) {

        this.candidateResults = candidateResults;
    }
}
