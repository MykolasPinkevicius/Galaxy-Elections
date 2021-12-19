package com.nasdaq.elections.services;

import com.nasdaq.elections.dao.BallotDao;
import com.nasdaq.elections.domain.Ballot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BallotService {

    private final BallotDao ballotDao;

    public BallotService(BallotDao ballotDao) {

        this.ballotDao = ballotDao;
    }

    public List<Ballot> findAll() {

        List<Ballot> ballots = new ArrayList<>();
        ballotDao.findAll().forEach(ballots::add);
        return ballots;
    }
}
