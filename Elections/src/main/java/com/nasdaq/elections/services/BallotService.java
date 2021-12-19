package com.nasdaq.elections.services;

import com.nasdaq.elections.domain.Ballot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BallotService {

    private final com.nasdaq.elections.dao.BallotDao ballotDao;

    public BallotService(com.nasdaq.elections.dao.BallotDao ballotDao) {

        this.ballotDao = ballotDao;
    }

    public List<Ballot> findAll() {

        List<Ballot> ballots = new ArrayList<>();
        ballotDao.findAll().forEach(ballots::add);
        return ballots;
    }
}
