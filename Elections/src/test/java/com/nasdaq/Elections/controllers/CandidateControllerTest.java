package com.nasdaq.Elections.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CandidateControllerTest {

    @Autowired
    private CandidateController candidateController;

    @Test
    public void springContextLoads() {
        assertThat(candidateController).isNotNull();
    }

}
