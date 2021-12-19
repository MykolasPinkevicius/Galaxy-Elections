package com.nasdaq.elections.dao;

import com.nasdaq.elections.domain.Ballot;
import com.nasdaq.elections.domain.Candidate;
import com.nasdaq.elections.domain.GalaxyRegion;
import org.springframework.data.repository.CrudRepository;

public interface BallotDao extends CrudRepository<Ballot, Long> {

    long countByCandidate(Candidate candidate);

    Iterable<Ballot> findAllByGalaxyRegion(GalaxyRegion galaxyRegion);

    long countByCandidateAndGalaxyRegion(Candidate candidate, GalaxyRegion galaxyRegion);
}
