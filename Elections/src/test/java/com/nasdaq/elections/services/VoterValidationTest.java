package com.nasdaq.elections.services;

import com.nasdaq.elections.domain.Voter;
import com.nasdaq.elections.exceptions.UserAlreadyVotedException;
import com.nasdaq.elections.testObjects.TestObjectProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VoterValidationTest {

    @Autowired
    private VoterService voterService;

    @Test
    public void should_throw_user_already_voted_exception() {

        // given
        Voter voter = TestObjectProvider.getVoter(1L);

        // when
        voterService.vote(voter);

        // then
        Assertions.assertThrows(UserAlreadyVotedException.class, () -> voterService.vote(voter));
    }
}
