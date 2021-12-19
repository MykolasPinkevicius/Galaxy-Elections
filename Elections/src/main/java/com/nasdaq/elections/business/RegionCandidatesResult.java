package com.nasdaq.elections.business;

import com.nasdaq.elections.domain.GalaxyRegion;

import java.util.List;

public class RegionCandidatesResult {

    private GalaxyRegion galaxyRegion;
    private List<CandidateResult> candidatesResult;

    public GalaxyRegion getGalaxyRegion() {

        return galaxyRegion;
    }

    public void setGalaxyRegion(GalaxyRegion galaxyRegion) {

        this.galaxyRegion = galaxyRegion;
    }

    public List<CandidateResult> getCandidatesResult() {

        return candidatesResult;
    }

    public void setCandidatesResult(List<CandidateResult> candidatesResult) {

        this.candidatesResult = candidatesResult;
    }
}
