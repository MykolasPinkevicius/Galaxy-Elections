package com.nasdaq.elections.controllers;

import com.nasdaq.elections.business.response.ElectionFinishResponse;
import com.nasdaq.elections.business.response.OverallVotesDistributionByRegionResponse;
import com.nasdaq.elections.business.response.OverallVotesDistributionResponse;
import com.nasdaq.elections.services.ElectionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/election")
public class ElectionController {

    private final ElectionService electionService;

    public ElectionController(ElectionService electionService) {

        this.electionService = electionService;
    }

    @Operation(summary = "Current overall votes distribution by votes count")
    @GetMapping("/overallVotesDistribution")
    public ResponseEntity<OverallVotesDistributionResponse> overallVotesDistribution() {

        return new ResponseEntity<>(electionService.overallVotesDistribution(), HttpStatus.OK);
    }

    @Operation(summary = "Current overall votes distribution by region")
    @GetMapping(path = "/overallByRegion")
    public ResponseEntity<OverallVotesDistributionByRegionResponse> overallVotesDistributionByRegion() {

        return new ResponseEntity<>(electionService.overallVotesDistributionByRegionResponse(), HttpStatus.OK);
    }

    @Operation(summary = "Returns candidate if he won by more than 50% else returns two who got the most votes")
    @GetMapping(path = "/finishElection")
    public ResponseEntity<ElectionFinishResponse> finishElection() {

        return new ResponseEntity<>(electionService.finishElection(), HttpStatus.OK);
    }
}
