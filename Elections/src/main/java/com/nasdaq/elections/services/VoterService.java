package com.nasdaq.elections.services;

import com.nasdaq.elections.dao.VoterDao;
import com.nasdaq.elections.domain.Voter;
import com.nasdaq.elections.exceptions.UserAlreadyVotedException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterService {

    private final VoterDao voterDao;

    public VoterService(VoterDao voterDao) {

        this.voterDao = voterDao;
    }

    public Voter vote(Voter voter) {

        validateVoter(voter);
        return voterDao.save(voter);
    }

    public Optional<Voter> findById(Long id) {

        return voterDao.findById(id);
    }

    private void validateVoter(Voter voter) {

        if (voter.getId() != null && findById(voter.getId()).isPresent()) {
            throw new UserAlreadyVotedException(String.format("Voter id %d already voted", voter.getId()));
        }
    }
}
