package com.nasdaq.elections.services;

import com.nasdaq.elections.domain.Candidate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CandidateService {

    public List<Candidate> getCandidates() {
        return Arrays.asList(Candidate.values());
    }
}
