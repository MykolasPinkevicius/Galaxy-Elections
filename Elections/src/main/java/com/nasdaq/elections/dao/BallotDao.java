package com.nasdaq.elections.dao;

import com.nasdaq.elections.domain.Ballot;
import org.springframework.data.repository.CrudRepository;

public interface BallotDao extends CrudRepository<Ballot, Long> {
}
