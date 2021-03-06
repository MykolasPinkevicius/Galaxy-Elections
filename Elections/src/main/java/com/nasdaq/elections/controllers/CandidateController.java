package com.nasdaq.elections.controllers;

import com.nasdaq.elections.domain.Candidate;
import com.nasdaq.elections.services.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @Operation(summary = "Gets all current candidates names, ballot numbers and agendas")
    @GetMapping
    public ResponseEntity<List<Candidate>> getCandidates() {

        return new ResponseEntity<>(candidateService.getCandidates(), HttpStatus.OK);
    }
}
