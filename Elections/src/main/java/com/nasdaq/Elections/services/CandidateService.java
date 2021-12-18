package com.nasdaq.Elections.services;

import com.nasdaq.Elections.domain.Candidate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CandidateService {

    public List<Candidate> getCandidates() {
        return Arrays.asList(Candidate.values());
    }
}
