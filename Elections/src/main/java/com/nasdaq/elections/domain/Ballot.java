package com.nasdaq.elections.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ballot {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "Vote must be present in Ballot")
    private Candidate candidate;
    @NotNull(message = "Galaxy Region must be present")
    private GalaxyRegion galaxyRegion;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Candidate getCandidate() {

        return candidate;
    }

    public void setCandidate(Candidate candidate) {

        this.candidate = candidate;
    }

    public GalaxyRegion getGalaxyRegion() {

        return galaxyRegion;
    }

    public void setGalaxyRegion(GalaxyRegion galaxyRegion) {

        this.galaxyRegion = galaxyRegion;
    }
}
