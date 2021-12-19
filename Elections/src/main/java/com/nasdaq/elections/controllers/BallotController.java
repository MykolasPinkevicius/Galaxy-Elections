package com.nasdaq.elections.controllers;

import com.nasdaq.elections.domain.Ballot;
import com.nasdaq.elections.services.BallotService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ballots")
public class BallotController {

    private final BallotService ballotService;

    public BallotController(BallotService ballotService) {

        this.ballotService = ballotService;
    }

    @Operation(summary = "Gets all current available ballots")
    @GetMapping
    public ResponseEntity<List<Ballot>> getBallots() {

        return new ResponseEntity<>(ballotService.findAll(), HttpStatus.OK);
    }
}
