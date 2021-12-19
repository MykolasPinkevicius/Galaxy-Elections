package com.nasdaq.elections.business.response;

import com.nasdaq.elections.business.CandidateResult;

public class SingleCandidateElectionFinishResponse implements ElectionFinishResponse {

    private CandidateResult candidateResult;

    public CandidateResult getCandidateResult() {

        return candidateResult;
    }

    public void setCandidateResult(CandidateResult candidateResult) {

        this.candidateResult = candidateResult;
    }
}
