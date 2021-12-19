package com.nasdaq.elections.services;

import com.nasdaq.elections.domain.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandidateServiceTest {

    private CandidateService candidateService;

    @BeforeEach
    public void setUp() {

        candidateService = new CandidateService();
    }

    @Test
    public void should_return_candidates() {

        // given
        List<Candidate> expectedCandidates = Arrays.asList(Candidate.values());

        // when
        List<Candidate> actualCandidates = candidateService.getCandidates();

        // then
        assertEquals(expectedCandidates, actualCandidates);

    }
}
