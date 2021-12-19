package com.nasdaq.elections.dao;

import com.nasdaq.elections.domain.Voter;
import org.springframework.data.repository.CrudRepository;

public interface VoterDao extends CrudRepository<Voter, Long> {
}
