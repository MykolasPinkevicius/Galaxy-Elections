package com.nasdaq.elections.business.response;

import com.nasdaq.elections.business.CandidateResult;

import java.util.List;

public class MultipleCandidatesElectionFinishResponse implements ElectionFinishResponse {

    private List<CandidateResult> candidateResult;

    public List<CandidateResult> getCandidateResult() {

        return candidateResult;
    }

    public void setCandidateResult(List<CandidateResult> candidateResult) {

        this.candidateResult = candidateResult;
    }
}
