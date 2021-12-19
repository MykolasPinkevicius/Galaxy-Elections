package com.nasdaq.elections.services;

import com.nasdaq.elections.dao.VoterDao;
import com.nasdaq.elections.domain.Voter;
import com.nasdaq.elections.testObjects.TestObjectProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class VoterServiceTest {

    private VoterService voterService;
    @Mock
    private VoterDao voterDao;

    @BeforeEach
    public void setUp() {

        openMocks(this);
        voterService = new VoterService(voterDao);
    }

    @Test
    public void should_save_voter_and_return_saved() {

        // given
        Voter expectedVoter = TestObjectProvider.getVoter(1L);
        when(voterDao.save(expectedVoter)).thenReturn(expectedVoter);

        // when
        Voter actualVoter = voterService.vote(expectedVoter);

        // then
        assertEquals(expectedVoter, actualVoter);
    }

    @Test
    public void should_return_voter_when_finding_by_id() {

        // given
        Optional<Voter> expectedVoter = Optional.of(TestObjectProvider.getVoter(1L));
        when(voterDao.findById(anyLong())).thenReturn(expectedVoter);

        // when
        Optional<Voter> actualVoter = voterService.findById(1L);

        // then
        assertEquals(expectedVoter, actualVoter);
    }
}
