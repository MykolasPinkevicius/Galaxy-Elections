package com.nasdaq.elections.business.response;

import com.nasdaq.elections.business.RegionCandidatesResult;

import java.util.List;

public class OverallVotesDistributionByRegionResponse {

    private List<RegionCandidatesResult> regionCandidatesResult;

    public List<RegionCandidatesResult> getRegionCandidatesResult() {

        return regionCandidatesResult;
    }

    public void setRegionCandidatesResult(List<RegionCandidatesResult> regionCandidatesResult) {

        this.regionCandidatesResult = regionCandidatesResult;
    }
}
