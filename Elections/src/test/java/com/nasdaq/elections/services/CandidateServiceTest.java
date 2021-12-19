package com.nasdaq.elections.services;

import com.nasdaq.elections.domain.Candidate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CandidateServiceTest {

    @Autowired
    private CandidateService candidateService;

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
